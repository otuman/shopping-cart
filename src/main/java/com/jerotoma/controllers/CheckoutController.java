package com.jerotoma.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("checkout")
public class CheckoutController {
	
	@RequestMapping("show")
	public ModelAndView showCartItems() {
		ModelAndView view =  new ModelAndView();
		view.setViewName("shop/checkout/checkout");
		view.addObject("title", "Checkout");
		return view;
	}


}
