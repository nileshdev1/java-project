package org.nk.controller.rest;

import java.util.List;

import org.nk.model.OrderMethod;
import org.nk.service.IOrderMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/order")
public class OrderMethodRestController {

	@Autowired
	private IOrderMethodService service;
	
	@GetMapping("/all")
	public ResponseEntity<?> fetchAllorder(){
		
		ResponseEntity<?> resp=null;
		
		try {
			List<OrderMethod> order=service.getAllOrderMethod();
			
			if(order!=null & !order.isEmpty()) {
				resp=new ResponseEntity<List<OrderMethod>>(order, HttpStatus.OK);			
			}else {
				resp=new ResponseEntity<String>(HttpStatus.NO_CONTENT);
			}
			
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Unable To Featch Data", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
	
	@GetMapping("/one")
	public ResponseEntity<?> fetchOneOrder(@RequestParam("id")Integer id){
		
		ResponseEntity<?> resp=null;
		
		try {
			OrderMethod order=service.getOneOrderMethod(id);
			
			if(order!=null) {
				resp=new ResponseEntity<OrderMethod>(order, HttpStatus.OK);
			}else {
				resp=new ResponseEntity<String>("Order "+id+ " Not Exist", HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Unable To Fetch Data", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	@DeleteMapping("/remove")
	public ResponseEntity<?> removeOrder(@RequestParam("id")Integer id){
		
		ResponseEntity<?> resp=null;
		
		try {
			service.deleteOrderMethod(id);
			resp=new ResponseEntity<String>("Order "+id+" Deleted", HttpStatus.OK);
			
		} catch (Exception e) {

			resp=new ResponseEntity<String>("Order "+id+ "Not Exist", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
		
	}
	@PostMapping("/save")
	public ResponseEntity<String> saveOrder(@RequestBody OrderMethod order){
		ResponseEntity<String> resp=null;
		
		try {
			Integer id=service.saveOrderMethod(order);
			resp=new ResponseEntity<String>("OrderMethod "+id+" Saved", HttpStatus.CREATED);
			
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Unable to save OrderMethod", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
	@PutMapping("/update")
	public ResponseEntity<String> updateOrder(@RequestBody OrderMethod order){
		ResponseEntity<String> resp=null;
		
		try {
			service.updateOrderMethod(order);
			resp=new ResponseEntity<String>("OrderMethod "+order.getOrderId()+" Updated", HttpStatus.RESET_CONTENT);
		}catch (Exception e) {
			resp=new ResponseEntity<String>("OrderMethod "+order.getOrderId()+" NotExist", HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		
		return resp;
	}
}
