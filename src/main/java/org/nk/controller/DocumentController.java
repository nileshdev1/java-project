package org.nk.controller;

import org.nk.model.Document;
import org.nk.service.IDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("docs")
public class DocumentController {

	@Autowired
	private IDocumentService service;
	
	@RequestMapping("/show")
	public String showUploadPage() {
		
		return "Documents";
	}
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String doUpload(
			@RequestParam Integer fileId,
			@RequestParam CommonsMultipartFile fileOb,
			Model model) {
		
		if(fileOb !=null) {
			Document doc=new Document();
			doc.setFileId(fileId);
			doc.setFileName(fileOb.getOriginalFilename());
			doc.setFileData(fileOb.getBytes());
			service.saveDocument(doc);
			String msg=fileId+" is Uploaded";
			model.addAttribute("message",msg);
		}
		return "Documents";
		
		
		
	}
	
}

