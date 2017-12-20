package com.jerotoma.controllers.dashboard;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jerotoma.model.User;
import com.jerotoma.services.UserService;

@Controller
@RequestMapping("/dashboard/products")
public class DashboardProductController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value= {"","/"},method=RequestMethod.GET)
	public ModelAndView getIndexView(Principal principal) {
		String username = principal.getName();
		User user = userService.getCurrentUser(username);
		
		
		ModelAndView view = new ModelAndView();
		view.setViewName("dashboard/pages/products/index");
		view.addObject("title", "Products");
		view.addObject("user", user);
		return view;
		
	}
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public ModelAndView getProductView(Principal principal) {
		
		String username = principal.getName();
		User user = userService.getCurrentUser(username);
		
		
		ModelAndView view = new ModelAndView();
		view.setViewName("dashboard/pages/products/create");
		view.addObject("title", "Products");
		view.addObject("user", user);
		return view;
		
	}
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public ModelAndView postProductView() {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("dashboard/pages/products/create");
		view.addObject("title", "Products");
		view.addObject("subtitle", "Add New Product");
		return view;
		
	}
	
	@RequestMapping("/{id}")
	public ModelAndView getShowView() {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("dashboard/pages/products/show");
		view.addObject("title", "Product");
		return view;
		
	}
	
	
	
}
