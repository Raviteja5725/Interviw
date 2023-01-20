package com.est.test.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.est.test.entity.User_Master;
import com.est.test.service.User_Master_Service_Interface;


@Controller
@RequestMapping(value = "/test")
public class User_master_Controller {
	
	@Autowired
	private User_Master_Service_Interface service;
	
	@PostMapping("/AddUser")
	public ResponseEntity<?> addEmployee(@RequestBody User_Master usermaster) {
		
			User_Master saveduser = service. AddUser( usermaster) ;
			
			return new ResponseEntity<User_Master>(saveduser, HttpStatus.CREATED);
	}
	
	@PutMapping("/UpdateUser")
	public ResponseEntity<?> updateUser(@RequestBody String userName, User_Master userMaster) {
		
		User_Master updatedUser = service. updateUser( userName,userMaster) ;
		
		return new ResponseEntity<User_Master>(updatedUser, HttpStatus.CREATED);
}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteGroupbyid(@PathVariable("id") Long id){
		
			service.deleteUserbyid(id);
			return new ResponseEntity<String>("user Deleted Successfully ",HttpStatus.OK);
			}
	
	 
		@GetMapping("/allusers")
		public ResponseEntity<List<User_Master>> getAllUsers() {
			List<User_Master> listOfusers = service.getAllUserdata();
			return new ResponseEntity<List<User_Master>>(listOfusers, HttpStatus.ACCEPTED);
		}
	
		 
			@GetMapping("/userbyId/{id}")
			public ResponseEntity<?> getEmployeeById(@PathVariable("id") Long id) {
					User_Master UserObtained = service.getuserbyId(id);
					return new ResponseEntity<User_Master>(UserObtained, HttpStatus.ACCEPTED);}
}
