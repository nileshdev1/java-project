package org.nk.controller;
import java.util.List;

import org.nk.model.Uom;
import org.nk.service.IUomService;
import org.nk.view.UomExcelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/uom")
public class UomController {
	
	@Autowired
	private IUomService service;
	
	/*
	 * This method is use to 
	 * show registration form
	 * of ShipmentType
	 */
	@RequestMapping("/register")
	public String showRegPage( @ModelAttribute Uom uom) {

		return "UomRegister";
	}

	/*
	 * This method is used to insert 
	 * given data through form
	 */

	@RequestMapping(value="/save", method=RequestMethod.POST) 
	public String saveUom(

			@ModelAttribute Uom uom,Model model) {

		Integer id=service.saveUom(uom); 

		String message="UOM "+id+" saved";

		model.addAttribute("message",message);

		return "UomRegister"; 
	}

	/*
	 * This method is used to 
	 * Fetch the data from database 
	 * and display all records
	 */
	@RequestMapping("/all")
	public String getAllUom(Model model) {

		List<Uom> list=service.getAllUom();
		model.addAttribute("list",list);

		return "UomData";
	}

	/*
	 * This method is used to delete
	 * the particular record given id
	 */
	@RequestMapping("/delete")
	public String deleteUom(
			@RequestParam("uid")Integer id,Model model) {

		service.deleteUom(id);
		String message="Record Deleted Sucessfully";
		model.addAttribute("message",message);

		List<Uom> list=service.getAllUom();
		model.addAttribute("list",list);

		return "UomData";
	}

	/*
	 * This method Display all details
	 * given id
	 */
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("uid")Integer id, Model model) {

		Uom st=service.getOneUom(id);
		model.addAttribute("uom", st);

		return "UomEdit";	
	}

	/*
	 *This method is used to
	 *update Existing content  
	 */
	@RequestMapping("/update")
	public String updateUom(@ModelAttribute Uom uom, Model model ) {
		
		service.updateUom(uom);
		String message="Uom"+uom.getUomId()+" Updeted";
		model.addAttribute("message",message);
		List<Uom> list=service.getAllUom();
		model.addAttribute("list", list);

		return "UomData";
	}
	
	/*
	 * 
	 */
	@RequestMapping("/view")
	public String showOneUom(@RequestParam("uid")Integer id, Model model) {
		
		Uom st=service.getOneUom(id);
		model.addAttribute("ob",st);
		
		return "UomView";
	}
	
	/*
	 * 
	 */
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		
		ModelAndView m=new ModelAndView();
		m.setView(new UomExcelView());
		List<Uom> list=service.getAllUom();
		m.addObject("list", list);
		
		return m;
	}

}
