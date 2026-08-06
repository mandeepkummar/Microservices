package com.mandeep.user.service.UserService.services;

import java.util.List;

import com.mandeep.user.service.UserService.entities.User;

public interface UserService {
	User saveUser(User user);
	List<User> getAllUsers();
	User getUser(String userId);
	
}
