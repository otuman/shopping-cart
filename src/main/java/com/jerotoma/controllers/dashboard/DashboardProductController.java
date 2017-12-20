package com.jerotoma.controllers.dashboard;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jerotoma.model.products.Product;
import com.jerotoma.model.users.User;
import com.jerotoma.services.ProductService;
import com.jerotoma.services.UserService;

@Controller
@RequestMapping("/dashboard/products")
public class DashboardProductController {
	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;
	
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
	public ModelAndView getCreate(Principal principal) {
		
		String username = principal.getName();
		User user = userService.getCurrentUser(username);
		
		
		ModelAndView view = new ModelAndView();
		view.setViewName("dashboard/pages/products/create");
		view.addObject("title", "Products");
		view.addObject("user", user);
		return view;
		
	}
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> postCreate(@RequestParam Map<String, String> params) {
		Map<String,Object> map =  new HashMap<String, Object>();
		
		System.out.println(params);
		
		Product product  = new Product(params); 
		productService.save(product);
		
		map.put("products", productService.getProducts());
		map.put("status", 200);
		map.put("message", "Data found");
				
		return map;
	}
	
	
	@RequestMapping("/{id}")
	public ModelAndView getShowView() {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("dashboard/pages/products/show");
		view.addObject("title", "Product");
		return view;
		
	}
	
	
	
}
