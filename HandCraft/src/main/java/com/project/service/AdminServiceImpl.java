package com.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.AdminDaoI;
import com.project.model.Admin;

@Service
public class AdminServiceImpl implements AdminServiceI{

	@Autowired
	private AdminDaoI d;
	@Override
	public Admin addAdmin(Admin admin) {
		if(admin != null) {
			Admin a = d.save(admin);
			return a;
		}else {
			return null;
		}
	}

	@Override
	public Admin editAdmin(int aid, Admin admin) {
		Optional<Admin> a = d.findById(aid);
		if(a.isPresent()) {
			a.get().setAid(admin.getAid());
			a.get().setaAddress(admin.getaAddress());
			a.get().setaName(admin.getaName());
			a.get().setMobileNo(admin.getMobileNo());
			a.get().setPassword(admin.getPassword());
			a.get().setProduct(admin.getProduct());
			a.get().setUserName(admin.getUserName());
			return d.save(a.get());
		}else {
			return null;
		}
	}

	@Override
	public String deleteAdmin(int aid) {
		Optional<Admin> a = d.findById(aid);
		if(a.isPresent()) {
			d.deleteById(aid);
			return ("Admin deleted successfully with aid " +aid);
		}else
			return null;
	}

	@Override
	public Admin searchAdmin(int aid) {
		Optional<Admin> a = d.findById(aid);
		if(a.isPresent()) {
			return a.get();
		}else {
			return null;
		}
	}

}
