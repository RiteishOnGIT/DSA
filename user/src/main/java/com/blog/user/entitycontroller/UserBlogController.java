package com.blog.user.entitycontroller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.user.entity.User;
import com.blog.user.service.UserService;

@RestController
public class UserBlogController {

	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public ArrayList<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	
	@PostMapping("/user")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	
	@PutMapping("/user")
	public void updateUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser( @PathVariable int id) {
		userService.deleteUser(id);
	}
}
