package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Product;

@Repository
public interface ProductDaoI extends JpaRepository<Product, Integer>{

}
