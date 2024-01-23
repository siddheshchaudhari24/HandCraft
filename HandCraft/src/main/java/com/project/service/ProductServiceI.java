package com.project.service;

import com.project.model.Product;

public interface ProductServiceI {
	
	public Product addProduct(Product product);
	
	public Product searchProduct(int pid);
	
	public Product editProduct(int pid, Product product);
	
	public String deleteproduct(int pid);
}
