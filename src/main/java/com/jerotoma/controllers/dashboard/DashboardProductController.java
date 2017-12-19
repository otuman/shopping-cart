package com.jerotoma.controllers.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dashboard/products")
public class DashboardProductController {
	
	@RequestMapping(value= {"","/"},method=RequestMethod.GET)
	public ModelAndView getIndexView() {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("dashboard/pages/products/index");
		view.addObject("title", "Products");
		return view;
		
	}
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public ModelAndView getProductView() {
		
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
