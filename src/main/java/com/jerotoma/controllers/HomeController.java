package com.jerotoma.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	
	@RequestMapping("/")
	public ModelAndView home(){
		ModelAndView view = new ModelAndView("index"); 	
		view.addObject("title", "Home");
		return view;
	}

	@RequestMapping("/about")
	public ModelAndView about(){
	 ModelAndView view = new ModelAndView("support/about"); 	
	 view.addObject("title", "About");
	 return view; 	
	}
	
	@RequestMapping("/contact")
	public ModelAndView contact(){
	    ModelAndView view = new ModelAndView("support/contact"); 	
		view.addObject("title", "Contact");
		return view; 
	}


}
