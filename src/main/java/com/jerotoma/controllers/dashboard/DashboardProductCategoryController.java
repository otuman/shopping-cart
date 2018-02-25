package com.jerotoma.controllers.dashboard;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jerotoma.model.Product;
import com.jerotoma.model.ProductCategory;
import com.jerotoma.model.User;
import com.jerotoma.services.ProductCategoryService;
import com.jerotoma.services.UserService;

@Controller
@RequestMapping("dashboard/products/categories")
public class DashboardProductCategoryController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ProductCategoryService productCategoryService;
	
	@RequestMapping(value= {"","/"},method=RequestMethod.GET)
	public ModelAndView getIndexView(Principal principal) {
		String username = principal.getName();
		User user = userService.getCurrentUser(username);
		ModelAndView view = new ModelAndView();
		view.setViewName("dashboard/pages/categories/index");
		view.addObject("title", "Categories");
		view.addObject("user", user);
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
	
	@RequestMapping(value= {"/all"},method=RequestMethod.GET)
	public @ResponseBody Map<String, ?> getAllProducts(){
		Map<String, Object> map = new HashMap<>();
		List<ProductCategory> productCategories = productCategoryService.getProductCategories();
		
		map.put("draw", 1);
		map.put("recordsTotal", productCategories.size());
		map.put("recordsFiltered", productCategories.size());
		map.put("data", productCategories);
		
		System.out.println(map);
		
		
		
		return map;
	}
	
}
