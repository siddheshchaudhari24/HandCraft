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
import com.project.model.Product;
import com.project.service.ProductServiceI;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductServiceI s;
	
	@PostMapping("/addproduct")
	public ResponseEntity<?> add(@RequestBody Product product) {
		Product p = s.addProduct(product);
		return new ResponseEntity<>(p, HttpStatus.CREATED);
	}
	
	@GetMapping("/search/{pid}")
	public ResponseEntity<?> search(@PathVariable int pid) throws ResourceNotFoundException{
		Product p = s.searchProduct(pid);
		if(p!=null) {
			return new ResponseEntity<>(p,HttpStatus.FOUND);
		}else {
			throw new ResourceNotFoundException("Product not found with the given pid: "+pid);
		}
	}
	
	@PutMapping("/edit/{pid}")
	public ResponseEntity<?> edit(@PathVariable("pid") int pid, @RequestBody Product product) throws ResourceNotFoundException{
		Product p = s.editProduct(pid,product);
		if(p!=null) {
			return new ResponseEntity<>(p, HttpStatus.OK);
		}
		else {
			throw new ResourceNotFoundException("Product not found with the pid: "+pid);
		}
		
	}
	
	@DeleteMapping("/delete/{pid}")
	public ResponseEntity<?> delete(@PathVariable("pid") int pid) throws ResourceNotFoundException{
		String msg = s.deleteproduct(pid);
		if(msg!=null) {
			return new ResponseEntity<>(msg, HttpStatus.OK);
		}
		else {
			throw new ResourceNotFoundException("Product not found with the pid: "+pid);
		}
	}
	

	
}
