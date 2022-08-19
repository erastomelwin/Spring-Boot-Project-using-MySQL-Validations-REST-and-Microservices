package com.example.demo.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public boolean checkIfUserExits(String name) {
		return userRepository.existsByName(name);
	}

	@Override
	public void updateUser(String coinDenominations, Integer noOfCoins, Double noOfHours, Integer userId) {
		userRepository.setUserInfoById(coinDenominations, noOfCoins, noOfHours, userId);
	}

}
