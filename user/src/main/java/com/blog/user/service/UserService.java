package com.blog.user.service;

import java.util.ArrayList;

import com.blog.user.entity.User;

public interface UserService{

	
	public ArrayList<User> getAllUsers();
	
	public User getUserById(int id);

	void addUser(User user);

	void deleteUser(int id);
	
}
