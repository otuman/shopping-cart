package com.jerotoma.controllers.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("dashboard/products/categories")
public class DashboardProductCategoryController {
	
	@RequestMapping(value= {"","/"},method=RequestMethod.GET)
	public ModelAndView getIndexView() {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("dashboard/pages/categories/index");
		view.addObject("title", "Categories");
		return view;
		
	}
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public ModelAndView getProductView() {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("dashboard/pages/categories/create");
		view.addObject("title", "Categories");
		return view;
		
	}
	
	@RequestMapping("/{id}")
	public ModelAndView getShowView() {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("dashboard/pages/categories/show");
		view.addObject("title", "Categories");
		return view; 
		
	}
	
}
