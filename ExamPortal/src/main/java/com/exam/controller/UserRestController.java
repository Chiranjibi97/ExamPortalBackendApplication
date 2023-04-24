package com.exam.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.Roles;
import com.exam.entity.User;
import com.exam.entity.UsersRole;
import com.exam.helper.UserNotFoundException;
import com.exam.service.IUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserRestController {

	@Autowired
	private IUserService service;

	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) throws Exception {
		Set<UsersRole> uRole = new HashSet<>();
		Roles role = new Roles();
		role.setRollId(20);
		role.setRoll_name("Normal");
		role.setUserRoles(uRole);

		UsersRole ur = new UsersRole();
		ur.setRole(role);
		ur.setUser(user);

		uRole.add(ur);
		user.setUserRole(uRole);

		return new ResponseEntity<>(service.registerUser(user), HttpStatus.OK);
	}
	

	@GetMapping("/get/{userName}")
	public ResponseEntity<User> getUserByUserName(@PathVariable String userName) throws UserNotFoundException {
		return new ResponseEntity<>(service.getUserByName(userName),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id){
		boolean isDelete = service.deleteUser(id);
		if(isDelete) {
			return new ResponseEntity<>("User deleted successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<>("User not deleted",HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateUser(@RequestBody User user){
		Boolean isUpdated = service.updateUser(user);
		if(isUpdated) {
			return new ResponseEntity<>("User Update successfully",HttpStatus.OK);			 
		}else {
			return new ResponseEntity<>("User not found for updatiion",HttpStatus.BAD_REQUEST);			 
		}
	}

}
