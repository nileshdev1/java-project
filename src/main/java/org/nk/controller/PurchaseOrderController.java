package org.nk.controller;

import java.util.List;
import java.util.Map;

import org.nk.model.PurchaseDtl;
import org.nk.model.PurchaseOrder;
import org.nk.service.IPartService;
import org.nk.service.IPurchaseOrderService;
import org.nk.service.IShipmentTypeService;
import org.nk.service.IWhUserTypeService;
import org.nk.util.CommonUtil;
import org.nk.view.VendorInvoicePdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("purchaseorder")
public class PurchaseOrderController {

	@Autowired
	private IPurchaseOrderService service;

	@Autowired
	private IShipmentTypeService shipservice;

	@Autowired
	private IPartService partService;

	@Autowired
	private IWhUserTypeService whservice;

	@SuppressWarnings("unused")
	private void commonUi(Model model) {

		List<Object[]> shiplist = shipservice.getShipIdandCode();
		Map<Integer, String> shipMap = CommonUtil.convert(shiplist);
		model.addAttribute("shipMap", shipMap);

		List<Object[]> whlist = whservice.getUserType("Vendor");
		Map<Integer, String> whmap = CommonUtil.convert(whlist);
		model.addAttribute("whmap", whmap);

	}

	/*
	 * This method is use to show registration form of ShipmentType
	 */
	@RequestMapping("/register")
	public String showRegPage(Model model) {

		model.addAttribute("purchaseOrder", new PurchaseOrder());
		commonUi(model);
		return "PurchaseOrderRegister";

	}

	/*
	 * This method is used to insert given data through form
	 */

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savePurchaseOrder(

			@ModelAttribute PurchaseOrder purchaseOrder, Model model) {

		Integer id = service.savePurchaseOrder(purchaseOrder);

		String message = "PurchaseOrder " + id + " saved";

		model.addAttribute("message", message);
		model.addAttribute("purchaseorder", new PurchaseOrder());
		commonUi(model);

		return "PurchaseOrderRegister";
	}

	/*
	 * This method is used to Fetch the data from database and display all records
	 */
	@RequestMapping("/all")
	public String getAllPurchaseOrder(Model model) {

		List<PurchaseOrder> list = service.getAllPurchaseOrder();

		model.addAttribute("list", list);

		return "PurchaseOrderData";
	}

	/*
	 * This method is used to delete the particular record given id
	 */
	@RequestMapping("/delete")
	public String deletePurchaseOrder(@RequestParam("oid") Integer id, Model model) {

		service.deletePurchaseOrder(id);
		String message = "Record Deleted Sucessfully";
		model.addAttribute("message", message);

		List<PurchaseOrder> list = service.getAllPurchaseOrder();
		model.addAttribute("list", list);

		return "PurchaseOrderData";
	}

	/*
	 * This method Display all details given id
	 */
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("oid") Integer id, Model model) {

		PurchaseOrder st = service.getOnePurchaseOrder(id);
		model.addAttribute("purchaseOrder", st);

		return "PurchaseOrderEdit";
	}

	/*
	 * This method is used to update Existing content
	 */
	@RequestMapping("/update")
	public String updatePurchaseOrder(@ModelAttribute PurchaseOrder purchaseOrder, Model model) {

		service.updatePurchaseOrder(purchaseOrder);
		String message = "SaleOrder" + purchaseOrder.getPoid() + " Updeted";
		model.addAttribute("message", message);
		List<PurchaseOrder> list = service.getAllPurchaseOrder();
		model.addAttribute("list", list);

		return "PurchaseOrderData";
	}

	/*
	 * it will show selected id details
	 */
	@RequestMapping("/view")
	public String showOnePurchaseOrder(@RequestParam("oid") Integer id, Model model) {

		PurchaseOrder st = service.getOnePurchaseOrder(id);
		model.addAttribute("ob", st);

		return "PurchaseOrderView";
	}
	
	
	
	/*
	 * SCREEN - 2 ***********************************************************************************************
	 */
	
	@RequestMapping("/parts")
	public String showChilds(@RequestParam("poId") Integer poId, Model model) {

		// get purchase Order Data
		PurchaseOrder po = service.getOnePurchaseOrder(poId);
		model.addAttribute("parent", po);

		// from Backing Object
		model.addAttribute("purchaseDtl", new PurchaseDtl());

		// DropDown Data
		List<Object[]> partsList = partService.getPartIdAndCode();
		Map<Integer, String> partsMap = CommonUtil.convert(partsList);
		model.addAttribute("partsMap", partsMap);

		// 4.Display all Parts which are added for this PO

		
		  List<PurchaseDtl> childs=po.getChilds(); int i=1; //slno setting
		  for(PurchaseDtl dtl:childs) { dtl.setSlno(i++); }
		  model.addAttribute("childs", childs);
		 

		return "PurchaseParts";

	}

	
	  //on click add part button
	  
	@RequestMapping(value = "/addPart",method = RequestMethod.POST)
	public String addPart(@ModelAttribute PurchaseDtl purchaseDtl) {
		service.savePurchaseDtl(purchaseDtl);
		Integer poId=purchaseDtl.getPo().getPoid();
		
		//at least one row added then status is picking
		service.updatePoStatus(poId, "PICKING");
		
		return "redirect:parts?poId="+poId;
	}
	
	//delete part by Id and send to PurchaseParts with parentId(poId)
	@RequestMapping("/removePart")
	public String deletePart(
			@RequestParam("dtlId")Integer dtlId,
			@RequestParam("poId")Integer poId
			) 
	{
		service.deletePurchaseDtl(dtlId);
		if(service.getOnePurchaseOrder(poId).getChilds().isEmpty()) {
			service.updatePoStatus(poId, "OPEN");
		}
		return "redirect:parts?poId="+poId;
	}
	
	@RequestMapping("/placeOrder")
	public String placeOrderConfirm(
			@RequestParam("poId")Integer poId
			) 
	{
		service.updatePoStatus(poId, "ORDERED");
		return "redirect:parts?poId="+poId;
	}
	
	@RequestMapping("/invoceOrder")
	public String placeOrderForInvoice(
			@RequestParam("poId")Integer poId
			) 
	{
		service.updatePoStatus(poId, "INVOICED");
		return "redirect:all";
	}
	
	//------------Generate PDF--------------
	@RequestMapping("/downloadInvoce")
	public ModelAndView downloadInvoiceAsPdf(
			@RequestParam("poId")Integer id
			)
	{
		PurchaseOrder po=service.getOnePurchaseOrder(id);
		ModelAndView m=new ModelAndView();
		m.setView(new VendorInvoicePdf());
		m.addObject("po", po);
		return m;
	}

}
