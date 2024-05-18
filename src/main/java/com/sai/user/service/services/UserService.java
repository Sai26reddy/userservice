package com.sai.user.service.services;

import java.util.List;

import com.sai.user.service.entities.User;

public interface UserService {
	
	User saveUser(User user);
	
	List<User> getAllUser();
	
	User getUser(String userId);
	
	User deleteUser(String userId);
	
	User updateUser(User user);
}
