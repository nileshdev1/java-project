package org.nk.controller;

import java.util.Arrays;
import java.util.List;

import org.nk.model.OrderMethod;
import org.nk.service.IOrderMethodService;
import org.nk.view.OrderMethodExcelView;
import org.nk.view.OrderMethodPdfView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/order")
public class OrderMethodController {

	@Autowired
	private IOrderMethodService service;

	/*
	 * This method is use to 
	 * show registration form
	 * of ShipmentType
	 */
	@RequestMapping("/register")
	public String showRegPage( @ModelAttribute OrderMethod ordermethod) {

		return "OrderMethodRegister";
	}

	/*
	 * This method is used to insert 
	 * given data through form
	 */

	@RequestMapping(value="/save", method=RequestMethod.POST) 
	public String saveOrderMethod(

			@ModelAttribute OrderMethod ordermethod,Model model) {

		Integer id=service.saveOrderMethod(ordermethod); 

		String message="OrderMethod "+id+" saved";

		model.addAttribute("message",message);

		return "OrderMethodRegister"; 
	}

	/*
	 * This method is used to 
	 * Fetch the data from database 
	 * and display all records
	 */
	@RequestMapping("/all")
	public String getAllOrderMethod(Model model) {

		List<OrderMethod> list=service.getAllOrderMethod();
		model.addAttribute("list",list);

		return "OrderMethodData";
	}

	/*
	 * This method is used to delete
	 * the particular record given id
	 */
	@RequestMapping("/delete")
	public String deleteOrderMethod(
			@RequestParam("oid")Integer id,Model model) {

		service.deleteOrderMethod(id);
		String message="Record Deleted Sucessfully";
		model.addAttribute("message",message);

		List<OrderMethod> list=service.getAllOrderMethod();
		model.addAttribute("list",list);

		return "OrderMethodData";
	}

	/*
	 * This method Display all details
	 * given id
	 */
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("oid")Integer id, Model model) {

		OrderMethod st=service.getOneOrderMethod(id);
		model.addAttribute("ordermethod", st);

		return "OrderMethodEdit";	
	}

	/*
	 *This method is used to
	 *update Existing content  
	 */
	@RequestMapping("/update")
	public String updateOrderMethod(@ModelAttribute OrderMethod ordermethod, Model model ) {

		service.updateOrderMethod(ordermethod);
		String message="OrderMethod"+ordermethod.getOrderId()+" Updeted";
		model.addAttribute("message",message);
		List<OrderMethod> list=service.getAllOrderMethod();
		model.addAttribute("list", list);

		return "OrderMethodData";
	}

	/*
	 *it will show selected id details 
	 */
	@RequestMapping("/view")
	public String showOneOrderMethod(@RequestParam("oid")Integer id, Model model) {

		OrderMethod st=service.getOneOrderMethod(id);
		model.addAttribute("ob",st);

		return "OrderMethodView";
	}

	/*
	 * Excel Export
	 */
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="id",required=false)Integer id) {

		ModelAndView m=new ModelAndView();
		m.setView(new OrderMethodExcelView());

		if(id==null) {

			List<OrderMethod> list=service.getAllOrderMethod();
			m.addObject("list", list);
		}
		else {

			OrderMethod om=service.getOneOrderMethod(id);
			m.addObject("list", Arrays.asList(om));
		}

		return m;
	}

	/*
	 * PDF Export
	 */
	@RequestMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value="id",required=false)Integer id) {

		ModelAndView m=new ModelAndView();
		m.setView(new OrderMethodPdfView());

		if(id==null) {

			List<OrderMethod> list=service.getAllOrderMethod();
			m.addObject("list", list);
		}
		else {

			OrderMethod om=service.getOneOrderMethod(id);
			m.addObject("list", Arrays.asList(om));
		}


		return m;
	}


}
