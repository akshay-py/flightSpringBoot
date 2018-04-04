package com.akshay.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.akshay.flightreservation.entities.User;
import com.akshay.flightreservation.repos.UserRepository;

@Controller
public class UserController {
	@Autowired
	UserRepository userRepo;

	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		return "login/registerUser";
	}

	@RequestMapping(value = "registerUser", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		userRepo.save(user);
		return "login/login";
	}
}
