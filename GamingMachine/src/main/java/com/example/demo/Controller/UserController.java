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
		int totalDenominations = Integer.parseInt(user.getCoinDenominations()) * user.getNoOfCoins();
		long playingSeconds = (long) (user.getNoOfHours() * 3600);
		double change = ((double) ((totalDenominations / 10) - user.getNoOfHours()) * 10);
		LocalTime activeTill = LocalTime.now().plusSeconds(playingSeconds);
		String message = null;
		if (user.getStatus().equals(Status.START)) {
			if (userServiceImp.checkIfUserExits(user.getName())) {
				int newDenominations = Integer.parseInt(user.getCoinDenominations()) * user.getNoOfCoins();
				long addedSeconds = (long) (user.getNoOfHours() * 3600);
				double newChange = ((double) ((newDenominations / 10) - user.getNoOfHours()) * 10);
				LocalTime newActiveTill = activeTill.plusSeconds(addedSeconds);

				userServiceImp.updateUser(user.getCoinDenominations(), user.getNoOfCoins(), user.getNoOfHours(),
						user.getUserId());

				message = "Message : Thankyou for continuing, your subscription is extended till " + newActiveTill
						+ ", \nReturned change: " + newChange;

				return message;
			}

			userServiceImp.addUser(user);

			message = "Message : Welcome to gaming, your subscription is active till " + activeTill
					+ ", \nReturned change: " + change;

			return message;

		} 
		else {
			if (userServiceImp.checkIfUserExits(user.getName())) {
				message = "Message : It's a pleasure gaming with you";
				
				return message;
			}
			message = "Message : Opps, To start playing press START! \n" + "Amount Returned: " + totalDenominations;

			return message;
		}

	}

}
