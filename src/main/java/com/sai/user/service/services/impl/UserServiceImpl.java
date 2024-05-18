package com.sai.user.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.user.service.entities.User;
import com.sai.user.service.exception.ResourceNotFoundException;
import com.sai.user.service.repositories.UserRepository;
import com.sai.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		String randomUserId= UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		return userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user with given id is not found on server !! :"+ userId));
	}

	@Override
	public User deleteUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
