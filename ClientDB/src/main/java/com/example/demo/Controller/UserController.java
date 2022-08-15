package com.example.demo.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.ServiceImp.UserServiceImp;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServiceImp userServiceImp;

	@PostMapping
	@RequestMapping("/register")
	public ResponseEntity<Map<Object,Object>> create(@Valid @RequestBody User user,
			@RequestHeader(value = "Status") String statusHandler,
			@RequestHeader(value = "StatusMsg") String statusMsgHandler) {
		User savedUser = userServiceImp.addUser(user);
		Map<Object,Object> headers=new HashMap<>();
		headers.put("Status", statusHandler);
		headers.put("StatusMsg", statusMsgHandler);
		headers.put("result", savedUser);
		return ResponseEntity.status(HttpStatus.OK).body(headers);
	}

	@GetMapping
	@RequestMapping("/getLastUser")
	public User getUser() {
		return userServiceImp.getLastUserByDateAndTime();
	}

}
