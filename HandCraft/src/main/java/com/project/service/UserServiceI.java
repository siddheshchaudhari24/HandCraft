package com.project.service;

import com.project.model.User;

public interface UserServiceI {
	
	public User addUser(User user);
	
	public User searchUser(int userId);
	
	public User editUser(int userId, User user);
	
	public String deleteUser(int userId);
}
