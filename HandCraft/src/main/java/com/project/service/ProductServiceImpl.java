package com.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.ProductDaoI;
import com.project.model.Product;

@Service
public class ProductServiceImpl implements ProductServiceI{

	@Autowired
	private ProductDaoI d;
	
	@Override
	public Product addProduct(Product product) {
		if(product!=null) {
		Product p2 = d.save(product);
		return p2;
		}else {
			return null;
		}
	}
	
	@Override
	public String deleteproduct(int pid) {
		Optional<Product> p = d.findById(pid);
		if(p.isPresent()) {
			d.deleteById(pid);
			return "Product deleted successfully with the id "+pid;
		}else {
			return null;
		}
	}
	
	@Override
	public Product editProduct(int pid, Product product) {
		Optional<Product> p = d.findById(pid);
		if(p.isPresent()) {
			p.get().setPid(product.getPid());
			p.get().setExpdate(product.getExpdate());
			p.get().setManufacturer(product.getManufacturer());
			p.get().setPdes(product.getPdes());
			p.get().setPrice(product.getPrice());
			p.get().setQuantity(product.getQuantity());
			return d.save(p.get());
		}else 
		{
			return null;
		}
	}

	@Override
	public Product searchProduct(int pid) {
		Optional<Product> p = d.findById(pid);
		if(p.isPresent()) {
			return p.get();
		}else {
			return null;
		}
	}
	

}
