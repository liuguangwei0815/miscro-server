package com.misco.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.misco.server.bean.User;
import com.misco.server.service.UserService;

@RestController
@RequestMapping("/cache")
public class UserController {
	@Autowired
	private UserService userService;
	@GetMapping("/{id:\\d+}")
	public User getUser(@PathVariable Long id) {
		return userService.getUser(id);
	}
}
