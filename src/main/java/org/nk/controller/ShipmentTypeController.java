package org.nk.controller;

import java.util.List;

import org.nk.model.ShipmentType;
import org.nk.service.IShipmentTypeService;
import org.nk.view.ShipmentTypeExcelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {

	@Autowired
	private IShipmentTypeService service;


	/*
	 * This method is use to 
	 * show registration form
	 * of ShipmentType
	 */
	@RequestMapping("/register")
	public String showRegPage( @ModelAttribute ShipmentType shipmentType) {

		return "ShipmentTypeRegister";
	}

	/*
	 * This method is used to insert 
	 * given data through form
	 */

	@RequestMapping(value="/save", method=RequestMethod.POST) 
	public String saveShipment(

			@ModelAttribute ShipmentType shipmentType,Model model) {

		Integer id=service.saveShipmentType(shipmentType); 

		String message="ShipmentType "+id+" saved";

		model.addAttribute("message",message);

		return "ShipmentTypeRegister"; 
	}

	/*
	 * This method is used to 
	 * Fetch the data from database 
	 * and display all records
	 */
	@RequestMapping("/all")
	public String getAllShipmentType( Model model) {

		List<ShipmentType> list=service.getAllShipmentType();
		System.out.println(list.toString());

		model.addAttribute("list",list);
		System.out.println(model.getAttribute("msg"));

		return "ShipmentTypeData";
	}

	/*
	 * This method is used to delete
	 * the particular record given id
	 */
	@RequestMapping("/delete")
	public String deleteShipment(
			@RequestParam("sid")Integer id,Model model) {

		service.deleteShipment(id);
		String message="Record Deleted Sucessfully";
		model.addAttribute("message",message);

		List<ShipmentType> list=service.getAllShipmentType();
		model.addAttribute("list",list);

		return "ShipmentTypeData";
	}

	/*
	 * This method Display all details
	 * given id
	 */
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("sid")Integer id, Model model) {

		ShipmentType st=service.getOneShipmentType(id);
		model.addAttribute("shipmentType", st);

		return "ShipmentTypeEdit";	
	}

	/*
	 *This method is used to
	 *update Existing content  
	 */
	@RequestMapping("/update")
	public String updateShipmentType(@ModelAttribute ShipmentType shipmentType, Model model ) {
		
		service.updateShipmentType(shipmentType);
		String message="ShipmentType"+shipmentType.getShipId()+" Updeted";
		model.addAttribute("message",message);
		List<ShipmentType> list=service.getAllShipmentType();
		model.addAttribute("list", list);

		return "ShipmentTypeData";
	}
	
	/*
	 * 
	 */
	@RequestMapping("/view")
	public String showOneShipment(@RequestParam("sid")Integer id, Model model) {
		
		ShipmentType st=service.getOneShipmentType(id);
		model.addAttribute("ob",st);
		
		return "ShipmentTypeView";
	}
	
	/*
	 * 
	 */
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		
		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypeExcelView());
		List<ShipmentType> list=service.getAllShipmentType();
		m.addObject("list", list);
		
		return m;
	}

}
