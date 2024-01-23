package com.project.model;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Product {
	@Id
	private int pid;
	private String pdes;
	private int quantity;
	private String manufacturer;
	private int expdate;
	private int price;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPdes() {
		return pdes;
	}
	public void setPdes(String pdes) {
		this.pdes = pdes;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getExpdate() {
		return expdate;
	}
	public void setExpdate(int expdate) {
		this.expdate = expdate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pdes=" + pdes + ", quantity=" + quantity + ", manufacturer=" + manufacturer
				+ ", expdate=" + expdate + ", price=" + price + "]";
	}
	
}
