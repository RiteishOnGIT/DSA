package com.blog.user.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.user.entity.User;
import com.blog.user.repository.UserRepository;
import com.blog.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public ArrayList<User> getAllUsers() {
		return (ArrayList<User>) userRepository.findAll();
	}

	@Override
	public User getUserById(int id) {
		return userRepository.getById((long) id);
	}
	
	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	@Override
	public void deleteUser(int id) {
		userRepository.deleteById((long)id);
	}
	
}
