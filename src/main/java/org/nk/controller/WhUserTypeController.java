package org.nk.controller;

import java.util.Arrays;
import java.util.List;

import org.nk.model.WhUserType;
import org.nk.service.IWhUserTypeService;
import org.nk.view.WhUserTypeExcelView;
import org.nk.view.WhUserTypePdfView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/whuser")
public class WhUserTypeController {

		@Autowired
		private IWhUserTypeService service;


		/*
		 * This method is use to 
		 * show registration form
		 * of WhUserType
		 */
		@RequestMapping("/register")
		public String showRegPage( @ModelAttribute WhUserType whUserType) {

			return "WhUserTypeRegister";
		}

		/*
		 * This method is used to insert 
		 * given data through form
		 */

		@RequestMapping(value="/save", method=RequestMethod.POST) 
		public String saveWhUserType(

				@ModelAttribute WhUserType whUserType,Model model) {

			Integer id=service.saveWhUserType(whUserType); 

			String message="WhUserType "+id+" saved";

			model.addAttribute("message",message);

			return "WhUserTypeRegister"; 
		}

		/*
		 * This method is used to 
		 * Fetch the data from database 
		 * and display all records
		 */
		@RequestMapping("/all")
		public String getAllWhUserType( Model model) {

			List<WhUserType> list=service.getAllWhUserType();

			model.addAttribute("list",list);

			return "WhUserTypeData";
		}

		/*
		 * This method is used to delete
		 * the particular record given id
		 */
		@RequestMapping("/delete")
		public String WhUserType(
				@RequestParam("sid")Integer id,Model model) {

			service.deleteWhUserType(id);
			String message="Record Deleted Sucessfully";
			model.addAttribute("message",message);

			List<WhUserType> list=service.getAllWhUserType();
			model.addAttribute("list",list);

			return "WhUserTypeData";
		}

		/*
		 * This method Display all details
		 * given id
		 */
		@RequestMapping("/edit")
		public String showEditPage(@RequestParam("sid")Integer id, Model model) {

			WhUserType st=service.getOneWhUserType(id);
			model.addAttribute("whUserType", st);

			return "WhUserTypeEdit";	
		}

		/*
		 *This method is used to
		 *update Existing content  
		 */
		@RequestMapping("/update")
		public String updateWhUserType(@ModelAttribute WhUserType whUserType, Model model ) {
			
			service.updateWhUserType(whUserType);
			String message="WhUserType"+whUserType.getWhUserId()+" Updeted";
			model.addAttribute("message",message);
			List<WhUserType> list=service.getAllWhUserType();
			model.addAttribute("list", list);

			return "WhUserTypeData";
		}
		
		/*
		 * it will show selected id details 
		 */
		@RequestMapping("/view")
		public String showOneWhUserType(@RequestParam("sid")Integer id, Model model) {
			
			WhUserType st=service.getOneWhUserType(id);
			model.addAttribute("ob",st);
			
			return "WhUserTypeView";
		}
		
		/*
		 * Excel Export
		 */
		@RequestMapping("/excel")
		public ModelAndView showExcel(@RequestParam(value="id",required=false)Integer id) {
			
			ModelAndView m=new ModelAndView();
			m.setView(new WhUserTypeExcelView());
			
			
			if(id==null) {
				List<WhUserType> list=service.getAllWhUserType();
				m.addObject("list", list);
			}
			else {
				WhUserType wh=service.getOneWhUserType(id);
				m.addObject("list", Arrays.asList(wh));
			}
			return m;
		}
		
		
		/*
		 *PDF Export 
		 */
		@RequestMapping("/pdf")
		public ModelAndView showPdf(@RequestParam(value="id",required=false)Integer id) {
			
			ModelAndView m=new ModelAndView();
			m.setView(new WhUserTypePdfView());
			

			if(id==null) {
				List<WhUserType> list=service.getAllWhUserType();
				m.addObject("list", list);
			}
			else {
				WhUserType wh=service.getOneWhUserType(id);
				m.addObject("list", Arrays.asList(wh));
			}
			return m;
		}

	

		
}

