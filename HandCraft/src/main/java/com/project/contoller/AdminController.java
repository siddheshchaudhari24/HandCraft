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
import com.project.model.Admin;
import com.project.service.AdminServiceI;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminServiceI s;
	
	@PostMapping("/addAdmin")
	public ResponseEntity<?> add(@RequestBody Admin admin){
		Admin s2 = s.addAdmin(admin);
		return new ResponseEntity<>(s2, HttpStatus.CREATED);
	}
	
	@GetMapping("/search/{aid}")
	public ResponseEntity<?> search(@PathVariable("aid")int aid)throws ResourceNotFoundException{
		Admin a2 = s.searchAdmin(aid);
		if(a2!=null) {
			return new ResponseEntity<>(a2,HttpStatus.FOUND);
		}else {
			throw new ResourceNotFoundException("Admin not found with the given aid: "+aid);
		}
	}
	
	@PutMapping("/edit/{aid}")
	public ResponseEntity<?> edit( @PathVariable("aid") int aid, @RequestBody Admin admin) 
		throws ResourceNotFoundException{
		Admin a2 = s.editAdmin(aid, admin);
		if(a2 != null)
			return new ResponseEntity<>(a2,HttpStatus.OK);
		else
			throw new ResourceNotFoundException("Admin not found with the given aid: " +aid);
	}
	
	@DeleteMapping("/delete/{aid}")
	public ResponseEntity<?> delete(@PathVariable int aid) throws ResourceNotFoundException{
		String msg = s.deleteAdmin(aid);
		if(msg != null) {
			return new ResponseEntity<>(msg, HttpStatus.OK);
		}
		else
			throw new ResourceNotFoundException("Admin not found with the given aid: "+aid);
	}
	
	
}
