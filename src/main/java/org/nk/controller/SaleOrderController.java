package org.nk.controller;

import java.util.List;

import org.nk.model.SaleOrder;
import org.nk.model.ShipmentType;
import org.nk.service.ISaleOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/saleorder")
public class SaleOrderController {

	@Autowired
	private ISaleOrderService service;
	
	
	/*
	 * This method is use to 
	 * show registration form
	 * of ShipmentType
	 */
	@RequestMapping("/register")
	public String showRegPage( @ModelAttribute SaleOrder saleOrder) {

		return "SaleOrderRegister";
	}

	/*
	 * This method is used to insert 
	 * given data through form
	 */

	@RequestMapping(value="/save", method=RequestMethod.POST) 
	public String saveSaleOrder(

			@ModelAttribute SaleOrder saleOrder,Model model) {

		Integer id=service.saveSaleOrder(saleOrder); 

		String message="SaleOrder "+id+" saved";

		model.addAttribute("message",message);

		return "SaleOrderRegister"; 
	}

	/*
	 * This method is used to 
	 * Fetch the data from database 
	 * and display all records
	 */
	@RequestMapping("/all")
	public String getAllSaleOrder( Model model) {

		List<SaleOrder> list=service.getAllSaleOrder();
		System.out.println(list.toString());

		model.addAttribute("list",list);
		System.out.println(model.getAttribute("msg"));

		return "SaleOrderData";
	}

	/*
	 * This method is used to delete
	 * the particular record given id
	 */
	@RequestMapping("/delete")
	public String deleteSaleOrder(
			@RequestParam("sid")Integer id,Model model) {

		service.deleteSaleOrder(id);
		String message="Record Deleted Sucessfully";
		model.addAttribute("message",message);

		List<SaleOrder> list=service.getAllSaleOrder();
		model.addAttribute("list",list);

		return "SaleOrderData";
	}

	/*
	 * This method Display all details
	 * given id
	 */
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("sid")Integer id, Model model) {

		SaleOrder st=service.getOneSaleOrder(id);
		model.addAttribute("saleOrder", st);

		return "SaleOrderEdit";	
	}

	/*
	 *This method is used to
	 *update Existing content  
	 */
	@RequestMapping("/update")
	public String updateSaleOrder(@ModelAttribute SaleOrder saleOrder, Model model ) {
		
		service.updateSaleOrder(saleOrder);
		String message="SaleOrder"+saleOrder.getSaleOid()+" Updeted";
		model.addAttribute("message",message);
		List<SaleOrder> list=service.getAllSaleOrder();
		model.addAttribute("list", list);

		return "SaleOrderData";
	}
	
	/*
	 * it will show selected id details 
	 */
	@RequestMapping("/view")
	public String showOneSaleOrder(@RequestParam("sid")Integer id, Model model) {
		
		SaleOrder st=service.getOneSaleOrder(id);
		model.addAttribute("ob",st);
		
		return "SaleOrderView";
	}
	
	
}
