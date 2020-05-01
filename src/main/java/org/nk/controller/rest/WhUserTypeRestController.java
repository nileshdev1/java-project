package org.nk.controller.rest;

import java.util.List;

import org.nk.model.WhUserType;
import org.nk.service.IWhUserTypeService;
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
@RequestMapping("/rest/whuser")
public class WhUserTypeRestController {

	@Autowired
	private IWhUserTypeService service;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllWhUser(){
		ResponseEntity<?> resp=null;
		
		try {
			List<WhUserType> list=service.getAllWhUserType();
			if(list==null || list.isEmpty()) {
				resp=new ResponseEntity<WhUserType>(HttpStatus.NO_CONTENT);
			}else {
				resp=new ResponseEntity<List<WhUserType>>(list, HttpStatus.OK);
			}
			
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Unable To Fetch WhUser", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
	@GetMapping("/one/{id}")
	public ResponseEntity<?> getOneWhUser(@PathVariable("id") Integer id){
		ResponseEntity<?> resp=null;
		
		try {
			WhUserType whuser=service.getOneWhUserType(id);
			if(whuser!=null){
				resp=new ResponseEntity<WhUserType>(HttpStatus.OK);
			}else {
				resp=new ResponseEntity<String>("WhUser"+id+" Not Exist", HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Unable To Fetch Data",HttpStatus.INTERNAL_SERVER_ERROR);
			
			e.printStackTrace();
		}
		return resp;
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveWhUser(@RequestBody WhUserType whUserType){
		ResponseEntity<String> resp=null;
		
		try {
			Integer id=service.saveWhUserType(whUserType);
			resp=new ResponseEntity<String>("WhUserType Saved With id "+id, HttpStatus.CREATED);
		
		
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Unable To Fetch Data", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateWhUser(@RequestBody WhUserType whuser){
		ResponseEntity<String> resp=null;
		
		try {
			service.updateWhUserType(whuser);
			resp=new ResponseEntity<String>("WhUser Id"+ whuser.getWhUserId()+ "Updated", HttpStatus.RESET_CONTENT);
			
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Unable To Fetch Data",HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeWhUser(@PathVariable("id") Integer id){
		ResponseEntity<String> resp=null;
		
		try {
			service.deleteWhUserType(id);
			resp=new ResponseEntity<String>("WhUser "+id+" Deleted", HttpStatus.OK);
			
		} catch (Exception e) {
			resp=new ResponseEntity<String>("WhUser "+id+" Not Found", HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return resp;
	}
}
