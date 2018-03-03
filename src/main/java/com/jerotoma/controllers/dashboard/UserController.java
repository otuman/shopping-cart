package com.jerotoma.controllers.dashboard;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jerotoma.helpers.FileUploadController;
import com.jerotoma.model.Media;
import com.jerotoma.model.Product;
import com.jerotoma.model.ProductDetail;
import com.jerotoma.model.ProductMedia;
import com.jerotoma.model.User;
import com.jerotoma.services.MediaService;
import com.jerotoma.services.ProductMediaService;
import com.jerotoma.services.ProductService;
import com.jerotoma.services.UserService;

@Controller
@RequestMapping("dashboard/users")
public class UserController {
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value= {"","/"},method=RequestMethod.GET)
	public ModelAndView getIndexView(Principal principal) {
		String username = principal.getName();
		User user = userService.getCurrentUser(username);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("dashboard/users/index");
		
		view.addObject("title", "Users");
		view.addObject("user", user);
		return view;
		
	}
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public ModelAndView getCreate(Principal principal) {
		
		String username = principal.getName();
		User user = userService.getCurrentUser(username);
		
		
		ModelAndView view = new ModelAndView();
		view.setViewName("dashboard/users/create");
		view.addObject("title", "User");
		view.addObject("user", user);
		return view;
		
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public @ResponseBody Map<String,?> postCreate(@RequestParam Map<String, String> params) {
		Map<String, Object> map =  new HashMap<String, Object>();
		
		System.out.println(params);
		
		User user  = new User(params); 
		userService.save(user);
		
		map.put("users", userService.users());
		map.put("status", 200);
		map.put("message", "Data found");
				
		return map;
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ModelAndView getShowView(@PathVariable("id") String id) {
		User user = userService.getCurrentUser(Integer.parseInt(id));
		ModelAndView view = new ModelAndView();
		view.setViewName("dashboard/users/show");
		view.addObject("title", "Product");
		view.addObject("user", user);
		return view;
		
	}
	
	
	@RequestMapping(value= {"/all"},method=RequestMethod.GET)
	public @ResponseBody Map<String, ?> getAllProducts(){
		Map<String, Object> map = new HashMap<>();
		List<User> users = userService.users();
		
		map.put("draw", 1);
		map.put("recordsTotal", users.size());
		map.put("recordsFiltered", users.size());
		map.put("data", users);
		
		System.out.println(map);
		
		
		
		return map;
	}
	
	
	
	
	
}
