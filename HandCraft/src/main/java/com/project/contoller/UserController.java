package com.project.contoller;

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

import com.project.Exception.ResourceNotFoundException;
import com.project.model.User;
import com.project.service.UserServiceI;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceI s;
	
	@PostMapping("/addUser")
	public ResponseEntity<?> add(@RequestBody User User) {
		User a2 = s.addUser(User);
		return new ResponseEntity<>(a2, HttpStatus.CREATED);
	}
	
	@GetMapping("/search/{userId}")
	public ResponseEntity<?> search(@PathVariable int userId)throws ResourceNotFoundException{
		User a2 = s.searchUser(userId);
		if(a2!=null) {
			return new ResponseEntity<>(a2, HttpStatus.FOUND);
		}else {
			throw new ResourceNotFoundException("User not found with the userId: "+userId);
		}
	}
	
	@PutMapping("/edit/{userId}")
	public ResponseEntity<?> edit(@PathVariable("userId") int userId,@RequestBody User User) throws ResourceNotFoundException{
		User a2 = s.editUser(userId, User);
		if(a2!=null) {
			return new ResponseEntity<>(a2, HttpStatus.OK);
		}
		else {
			throw new ResourceNotFoundException("User not found with userId: "+userId);
		}
	}
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<?> delete(@PathVariable("userId") int userId)throws ResourceNotFoundException{
		String msg = s.deleteUser(userId);
		if(msg!=null) {
			return new ResponseEntity<>(msg,HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("User not found with userId: "+userId);
		}
	}
}
