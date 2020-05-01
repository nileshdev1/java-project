package org.nk.controller.rest;

import java.util.List;

import org.nk.model.Part;
import org.nk.service.IPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/part")
public class PartRestController {

	@Autowired
	private IPartService service;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllParts(){
		ResponseEntity<?> resp=null;
		
		try {
			List<Part> list=service.getAllPart();
			if(list==null || list.isEmpty()) {
				resp=new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				resp=new ResponseEntity<List<Part>>(list, HttpStatus.OK);
			}
			
		} catch (Exception e) {

			resp=new ResponseEntity<String>("Unable To Fetch Parts", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		
		return resp;
	}
	
	@GetMapping("/one/{id}")
	public ResponseEntity<?> getOnePart(@PathVariable("id") Integer id){
		ResponseEntity<?> resp=null;
		
		try {
			Part part=service.getOnePart(id);
			if(part!=null) {
				resp=new ResponseEntity<Part>(part, HttpStatus.OK);
			}else {
				resp=new ResponseEntity<String>("Part"+ id+ "Not Exist", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {

			resp=new ResponseEntity<String>("Unable to Fetch Parts", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> savePart(@RequestBody Part part){
		
		ResponseEntity<String> resp=null;
		
		try {
			Integer id=service.savePart(part);
			resp=new ResponseEntity<String>("Part Saved With Id"+ id, HttpStatus.CREATED);
			
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Unable To save Part", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updatePart(@RequestBody Part part){
		ResponseEntity<String> resp=null;
		
		try {
			service.updatePart(part);
			resp=new ResponseEntity<String>("Part "+part.getPid()+" Updated", HttpStatus.RESET_CONTENT);
			
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Part"+ part.getPid()+"Not Exist", HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return resp;
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removePart(@PathVariable("id") Integer id){
		
		ResponseEntity<String> resp=null;
		try {
			service.deletePart(id);
			resp=new ResponseEntity<String>("Part "+id+" Deleted", HttpStatus.OK);
			
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Part"+ id+ "Not Found",HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return resp;
	}
}
