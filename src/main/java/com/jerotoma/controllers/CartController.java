package com.jerotoma.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("cart")
public class CartController {
	
	@RequestMapping("show")
	public ModelAndView showCartItems() {
		ModelAndView view =  new ModelAndView();
		view.setViewName("shop/cart/show-cart-items");
		view.addObject("title", "Cart");
		return view;
	}

}
