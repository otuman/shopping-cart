package com.jerotoma.controllers;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jerotoma.model.User;
import com.jerotoma.services.UserService;



@Controller
@RequestMapping("/myaccount")
public class AuthController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView loginView() {
		ModelAndView view =  new ModelAndView();
		view.setViewName("auth/login");
		view.addObject("title", "Login");
		return view;
	}
	
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public ModelAndView signoutView() {
		ModelAndView view =  new ModelAndView();
		view.setViewName("auth/login");
		view.addObject("title", "Signout");
		return view;
	}
	
	@RequestMapping(value="/loginfailed",method=RequestMethod.GET)
	public ModelAndView signInFailedView() {
		ModelAndView view =  new ModelAndView();
		view.setViewName("auth/login");
		view.addObject("title", "Sing In Failed");
		return view;
	}
	
	
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public ModelAndView signupView() {
		ModelAndView view =  new ModelAndView();
		view.setViewName("auth/signup");
		view.addObject("title", "Register");
		return view;
	}
	
//	@RequestMapping(value="/create",method=RequestMethod.POST)
//	public ModelAndView createView(@RequestParam Map<String, String> params) {
//		ModelAndView view =  new ModelAndView();
//		System.out.println(params.get("first_name"));
//		System.out.println(params);
//		
//		User user  = new User(params); 
//		userService.save(user);
//		
//		
//		view.setViewName("auth/signup");
//		view.addObject("title", "Register");
//		view.addObject("users", userService.users());
//		
//		return view;
//	}
//	
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> postCreate(@RequestParam Map<String, String> params) {
		Map<String,Object> map =  new HashMap<String, Object>();
		
		System.out.println(params);
		
		User user  = new User(params); 
		userService.save(user);
		
		map.put("users", userService.users());
		map.put("status", 200);
		map.put("message", "Data found");
				
		return map;
	}
	
	

}
