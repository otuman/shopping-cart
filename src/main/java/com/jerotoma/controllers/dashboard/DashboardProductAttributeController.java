package com.jerotoma.controllers.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/dashboard/products/attributes")
public class DashboardProductAttributeController {
	@RequestMapping(value= {"","/"},method=RequestMethod.GET)
	public ModelAndView getIndexView() {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("dashboard/pages/attributes/index");
		view.addObject("title", "Attributes");
		return view;
		
	}
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public ModelAndView getProductView() {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("dashboard/pages/attributes/create");
		view.addObject("title", "Attributes");
		return view;
		
	}
	
	@RequestMapping("/{id}")
	public ModelAndView getShowView() {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("dashboard/pages/attributes/show");
		view.addObject("title", "Attributes");
		return view; 
		
	}
}
