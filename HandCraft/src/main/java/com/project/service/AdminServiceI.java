package com.project.service;

import com.project.model.Admin;

public interface AdminServiceI {
	
	public Admin addAdmin(Admin admin);
	
	public Admin searchAdmin(int aid);
	
	public Admin editAdmin (int aid, Admin admin);
	
	public String deleteAdmin(int aid);
}
