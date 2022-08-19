package com.example.demo.Service;

import com.example.demo.Entity.User;

public interface UserService {

	User addUser(User user);
	boolean checkIfUserExits(String name);
	void updateUser(String coinDenominations, Integer noOfCoins, Double noOfHours, Integer userId);
	
}
