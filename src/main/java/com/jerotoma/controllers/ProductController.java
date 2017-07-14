package com.jerotoma.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/shop")
public class ProductController {
    
	@RequestMapping("/products")
	public ModelAndView getProductView() {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("shop/products/products");
		
		return view;
		
	}
	
	@RequestMapping("/products/{name}")
	public ModelAndView getSingleProductView() {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("shop/products/product-single");
		
		return view;
		
	}
}
