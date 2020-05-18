package in.nit.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.model.Uom;
import in.nit.service.IUomService;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
@Controller
@RequestMapping("/uom")
public class UomController {
	@Autowired
	private IUomService service;

	@RequestMapping("/register")
	public String regUom(ModelMap map) {
		map.addAttribute("uom",new Uom());
		return "UomRegister";
	}

	@RequestMapping(value = "/save",method = POST)
	public String saveUom(@ModelAttribute Uom uom, ModelMap map) {
		Integer id=service.saveUom(uom);
		map.addAttribute("message","Uom created with Id:"+id);
		map.addAttribute("uom",new Uom()) ;
		return "UomRegister";
	}

	@RequestMapping(
			value = "/update",
			method = POST
			)
	public String updateUom(@ModelAttribute Uom uom, ModelMap map) {
		service.updateUom(uom);
		map.addAttribute("message","Uom updated");
		List<Uom> list=service.getAllUoms();
		map.addAttribute("list",list);
		return "UomData";
	}

	@RequestMapping("/delete")
	public String deleteUom(@RequestParam Integer id, ModelMap map) {
		service.deleteUom(id);
		map.addAttribute("message","Uom deleted with Id:"+id);
		List<Uom> list=service.getAllUoms();
		map.addAttribute("list",list);
		return "UomData";
	}

	@RequestMapping("/edit")
	public String editUom(@RequestParam Integer id, ModelMap map) {
		Uom ob=service.getOneUom(id);
		map.addAttribute("uom",ob);
		return "UomEdit";
	}

	@RequestMapping("/all")
	public String getAllUoms(ModelMap map) {
		List<Uom> list=service.getAllUoms();
		map.addAttribute("list",list);
		return "UomData";
	}
}
