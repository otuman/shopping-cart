package com.jerotoma.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jerotoma.model.User;

@Controller
@RequestMapping("/myaccount")
public class AuthController {
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView loginView() {
		ModelAndView view =  new ModelAndView();
		view.setViewName("auth/login");
		view.addObject("title", "Login");
		return view;
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView postLogin(@RequestParam("username")String username, @RequestParam("password")String password) {
		
		User user  = new User(username, password);		
		ModelAndView view =  new ModelAndView();
		view.setViewName("auth/login");
		view.addObject("title", "Login");
		view.addObject("user", user);
		return view;
	}
	
	
	
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public ModelAndView signupView() {
		ModelAndView view =  new ModelAndView();
		view.setViewName("auth/signup");
		view.addObject("title", "Register");
		return view;
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public ModelAndView createView(@RequestParam Map<String, String> params) {
		ModelAndView view =  new ModelAndView();
		view.setViewName("auth/signup");
		view.addObject("title", "Register");
		return view;
	}

}
