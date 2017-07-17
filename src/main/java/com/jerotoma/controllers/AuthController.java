package com.jerotoma.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/myaccount")
public class AuthController {
	
	@RequestMapping("/login")
	public ModelAndView loginView() {
		ModelAndView view =  new ModelAndView();
		view.setViewName("auth/login");
		view.addObject("title", "Login");
		return view;
	}
	@RequestMapping("/register")
	public ModelAndView signupView() {
		ModelAndView view =  new ModelAndView();
		view.setViewName("auth/signup");
		view.addObject("title", "Register");
		return view;
	}

}
