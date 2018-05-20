package com.akshay.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.akshay.flightreservation.entities.User;
import com.akshay.flightreservation.repos.UserRepository;
import com.akshay.flightreservation.service.SecurityService;

@Controller
public class UserController {
	@Autowired
	UserRepository userRepo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	SecurityService securityService;

	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		return "login/registerUser";
	}

	@RequestMapping("/showLogin")
	public String showLoginPage() {
		return "login/login";
	}

	@RequestMapping(value = "registerUser", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") final User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepo.save(user);
		return "login/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") final String email, @RequestParam("password") final String password, final ModelMap modelMap) {
		final boolean loginResponse = securityService.login(email, password);
		if (loginResponse) {
			return "findFlights";
		} else {
			modelMap.addAttribute("msg", "Invalid user name or password. Please try again.");
		}
		return "login/login";
	}
}
