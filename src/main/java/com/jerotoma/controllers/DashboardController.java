package com.jerotoma.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	
	@RequestMapping(value= {"","/","/index","/home"},method=RequestMethod.GET)
	public String index(ModelMap model, Principal principal) {
		
		String username = principal.getName();
		model.addAttribute("title", username);
		model.addAttribute("username", username);
		model.addAttribute("message", "Conguratulations for successiful login");
		return "dashboard/dashboard";		
		
	}
	
	
	@RequestMapping(value= {"/profile","/profile/"},method=RequestMethod.GET)
	public String profile(ModelMap model, Principal principal) {
		
		String username = principal.getName();
		model.addAttribute("title", "User Profile");
		model.addAttribute("username", username);
		model.addAttribute("message", "Profile");
		return "dashboard/pages/profile";		
		
	}
	
	@RequestMapping(value= {"/settings","/settings/"},method=RequestMethod.GET)
	public String settings(ModelMap model, Principal principal) {
		
		String username = principal.getName();
		model.addAttribute("title", "User Settings");
		model.addAttribute("username", username);
		model.addAttribute("message", "Settings");
		return "dashboard/pages/settings";		
		
	}
	

}
