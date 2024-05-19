package com.sai.userService.service;

import java.util.List;

import com.sai.userService.model.User;



public interface UserService {
	
	User saveUser(User user);
	
	List<User> getAllUser();
	
	User getUser(String userId);
	
	User deleteUser(String userId);
	
	User updateUser(User user);
}
