package com.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.UserDaoI;
import com.project.model.User;

@Service
public class UserServiceImpl implements UserServiceI{
	
	@Autowired
	private UserDaoI d;
	
	@Override
	public User addUser(User user) {
		if(user!=null) {
		User u = d.save(user);
		return u;
		}else {
			return null;
		}
		
	}

	@Override
	public User editUser(int userId, User user) {
		Optional<User> u = d.findById(userId);
		if(u.isPresent()) {
			u.get().setUserId(user.getUserId());
			u.get().setuName(user.getuName());
			u.get().setUserAddress(user.getUserAddress());
			u.get().setMobileNo(user.getMobileNo());
			u.get().setUserName(user.getUserName());
			u.get().setPassword(user.getPassword());
			u.get().setProduct(user.getProduct());
			return d.save(u.get());
		}else
			return null;
	}

	@Override
	public String deleteUser(int userId) {
		Optional<User> u = d.findById(userId);
		if(u.isPresent()) {
			d.deleteById(userId);
			return "User deleted successfully with userid: "+userId;
		}else {
			return null;
		}
	}

	@Override
	public User searchUser(int userId) {
		Optional<User> u = d.findById(userId);
		if(u.isPresent()) {
			return u.get();
		}else {
			return null;
		}
	}

}
