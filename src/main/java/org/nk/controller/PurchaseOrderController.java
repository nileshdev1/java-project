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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		List<Object[]> shiplist=shipservice.getShipIdandCode();
		Map<Integer,String> shipMap=CommonUtil.convert(shiplist);
		model.addAttribute("shipMap", shipMap);
		
		
		List<Object[]> whlist=whservice.getUserType("vender");
		Map<Integer,String> whmap=CommonUtil.convert(whlist); 
		model.addAttribute("whmap", whmap);
		
		
	}
	/*
	 * This method is use to 
	 * show registration form
	 * of ShipmentType
	 */
	@RequestMapping("/register")
	public String showRegPage( Model model) {

		model.addAttribute("purchaseOrder", new PurchaseOrder());
		commonUi(model);
		return "PurchaseOrderRegister";
		
	}

	/*
	 * This method is used to insert 
	 * given data through form
	 */

	@RequestMapping(value="/save", method=RequestMethod.POST) 
	public String savePurchaseOrder(

			@ModelAttribute PurchaseOrder purchaseOrder,Model model) {

		Integer id=service.savePurchaseOrder(purchaseOrder); 

		String message="PurchaseOrder "+id+" saved";

		model.addAttribute("message",message);
		model.addAttribute("purchaseorder", new PurchaseOrder());
		commonUi(model);

		return "PurchaseOrderRegister"; 
	}

	/*
	 * This method is used to 
	 * Fetch the data from database 
	 * and display all records
	 */
	@RequestMapping("/all")
	public String getAllPurchaseOrder( Model model) {

		List<PurchaseOrder> list=service.getAllPurchaseOrder();

		model.addAttribute("list",list);

		return "PurchaseOrderData";
	}

	/*
	 * This method is used to delete
	 * the particular record given id
	 */
	@RequestMapping("/delete")
	public String deletePurchaseOrder(
			@RequestParam("oid")Integer id,Model model) {

		service.deletePurchaseOrder(id);
		String message="Record Deleted Sucessfully";
		model.addAttribute("message",message);

		List<PurchaseOrder> list=service.getAllPurchaseOrder();
		model.addAttribute("list",list);

		return "PurchaseOrderData";
	}

	/*
	 * This method Display all details
	 * given id
	 */
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("oid")Integer id, Model model) {

		PurchaseOrder st=service.getOnePurchaseOrder(id);
		model.addAttribute("purchaseOrder", st);

		return "PurchaseOrderEdit";	
	}

	/*
	 *This method is used to
	 *update Existing content  
	 */
	@RequestMapping("/update")
	public String updatePurchaseOrder(@ModelAttribute PurchaseOrder purchaseOrder, Model model ) {
		
		service.updatePurchaseOrder(purchaseOrder);
		String message="SaleOrder"+purchaseOrder.getPoid()+" Updeted";
		model.addAttribute("message",message);
		List<PurchaseOrder> list=service.getAllPurchaseOrder();
		model.addAttribute("list", list);

		return "PurchaseOrderData";
	}
	
	/*
	 * it will show selected id details 
	 */
	@RequestMapping("/view")
	public String showOnePurchaseOrder(@RequestParam("oid")Integer id, Model model) {
		
		PurchaseOrder st=service.getOnePurchaseOrder(id);
		model.addAttribute("ob",st);
		
		return "PurchaseOrderView";
	}
	
	@RequestMapping("/parts")
	public String showChilds(@RequestParam("poId") Integer poId, Model model) {
		
		//get purchase Order Data
		PurchaseOrder po=service.getOnePurchaseOrder(poId);
		model.addAttribute("po", po);
		
		//from Backing Object
		model.addAttribute("purchaseDtl", new PurchaseDtl());
		
		//DropDown Data
		List<Object[]> partsList=partService.getPartIdAndCode();
		Map<Integer,String> partsMap=CommonUtil.convert(partsList);
		
		return "PurchaseParts";
		
	}
	
	
}


