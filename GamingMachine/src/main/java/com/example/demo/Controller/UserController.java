package com.example.demo.Controller;

import java.time.LocalTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Status;
import com.example.demo.Entity.User;
import com.example.demo.ServiceImp.UserServiceImp;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImp userServiceImp;
	
	@PostMapping
	@RequestMapping("/enterCoins")
	public String addUser(@Valid @RequestBody User user) {
		userServiceImp.addUser(user);
		int totalDenominations=Integer.parseInt(user.getCoinDenominations())*user.getNoOfCoins();
//		long totalSeconds= (totalDenominations/10)*3600;
		long playingSeconds=(long) (user.getNoOfHours()*3600);
		double change=((double)((totalDenominations/10)-user.getNoOfHours())*10);
		LocalTime activeTill= LocalTime.now().plusSeconds(playingSeconds);
		String message=null;
		if(user.getStatus().equals(Status.START)) {
			message="Message : Welcome to gaming, your subscription is active till "+ activeTill+
					", \nReturned change: "+ change;
			
			return message;
		}
		else {
			message="Message : It's a pleasure gaming with you, \n"
					+ "Amount Returned: "+ totalDenominations;
			
			return message;
		}
		
		
	}
	
}
