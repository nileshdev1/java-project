package org.nk.controller;

import java.util.List;
import java.util.Map;

import org.nk.model.Part;
import org.nk.service.IOrderMethodService;
import org.nk.service.IPartService;
import org.nk.service.IUomService;
import org.nk.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/part")
public class PartController {

	@Autowired
	private IPartService service;

	@Autowired
	private IUomService uomservice;

	@Autowired
	private IOrderMethodService orderMethodService;

	/*
	 * It will show show drop down at ui
	 */
	@SuppressWarnings("unused")
	private void commonui(Model model) {

		//FOR UOM MODEL
		List<Object[]> uomlist=uomservice.getOrderIdAndModel();
		Map<Integer,String> uomMap=CommonUtil.convert(uomlist);
		model.addAttribute("uomMap", uomMap);

		//FOR SALE ORDER CODE
		List<Object[]> omSaleList=orderMethodService.getOrderIdAndCode("Sale");
		Map<Integer,String> omSaleMap=CommonUtil.convert(omSaleList);
		model.addAttribute("omSaleMap", omSaleMap);

		//FOR PURCHASE ORDER CODE
		List<Object[]> omPurchaseList=orderMethodService.getOrderIdAndCode("Purchase");
		Map<Integer,String> omPurchaseMap=CommonUtil.convert(omPurchaseList);
		model.addAttribute("omPurchaseMap", omPurchaseMap);


	}
	/*
	 * This method is use to 
	 * show registration form
	 * of ShipmentType
	 */
	@RequestMapping("/register")
	public String showRegPage( Model model) {

		//from backing object
		model.addAttribute("part", new Part());
		commonui(model);
		return "PartRegister";
	}

	/*
	 * This method is used to insert 
	 * given data through form
	 */

	@RequestMapping(value="/save", method=RequestMethod.POST) 
	public String savePart(

			@ModelAttribute Part part,Model model) {

		Integer id=service.savePart(part); 

		String message="PART "+id+" Created";

		model.addAttribute("message",message);

		model.addAttribute("part", new Part());
		commonui(model);

		return "PartRegister"; 
	}

	/*
	 * This method is used to 
	 * Fetch the data from database 
	 * and display all records
	 */
	@RequestMapping("/all")
	public String getAllPart(Model model) {

		List<Part> list=service.getAllPart();
		model.addAttribute("list",list);

		return "PartData";
	}

	/*
	 * This method is used to delete
	 * the particular record given id
	 */
	@RequestMapping("/delete")
	public String deletePart(
			@RequestParam("pid")Integer id,Model model) {

		service.deletePart(id);
		String message="Record Deleted Sucessfully";
		model.addAttribute("message",message);

		List<Part> list=service.getAllPart();
		model.addAttribute("list",list);

		return "PartData";
	}

	/*
	 * This method Display all details
	 * given id
	 */
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("pid")Integer id, Model model) {

		Part pt=service.getOnePart(id);
		model.addAttribute("part", pt);

		return "PartEdit";	
	}

	/*
	 *This method is used to
	 *update Existing content  
	 */
	@RequestMapping("/update")
	public String updatePart(@ModelAttribute Part part, Model model ) {

		service.updatePart(part);
		String message="PART"+part.getPid()+" Updeted";
		model.addAttribute("message",message);
		List<Part> list=service.getAllPart();
		model.addAttribute("list", list);

		return "PartData";
	}

	/*
	 * it will show selected id details 
	 */
	@RequestMapping("/view")
	public String showOnePart(@RequestParam("pid")Integer id, Model model) {

		Part pt=service.getOnePart(id);
		model.addAttribute("ob",pt);

		return "PartView";
	}


}
