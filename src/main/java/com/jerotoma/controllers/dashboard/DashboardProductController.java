package com.jerotoma.controllers.dashboard;

import java.security.Principal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.jerotoma.helpers.FileUploadController;
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
	public @ResponseBody Map<String,Object> postCreate(@RequestParam Map<String, String> params, MultipartHttpServletRequest request) {
		Map<String,Object> map =  new HashMap<String, Object>();
		Product product  = new Product(params); 
		//Iterator<String> itr =  request.getFileNames();		 
        //MultipartFile file = request.getFile(itr.next());
       
      // FileUploadController uploadFile = FileUploadController.getInstance();
       //uploadFile.uploadFileHandler(file.getOriginalFilename(), file);
       
      // System.out.println(file.getOriginalFilename() +" uploaded!");
	   //System.out.println(file);
	   System.out.println(params);
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
