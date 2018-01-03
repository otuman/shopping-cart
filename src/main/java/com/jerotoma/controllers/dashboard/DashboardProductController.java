package com.jerotoma.controllers.dashboard;

import java.security.Principal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.jerotoma.helpers.FileUploadController;
import com.jerotoma.model.Media;
import com.jerotoma.model.Product;
import com.jerotoma.model.User;
import com.jerotoma.services.MediaService;
import com.jerotoma.services.ProductService;
import com.jerotoma.services.UserService;

@Controller
@RequestMapping("/dashboard/products")
public class DashboardProductController {
		
	@Autowired
	UserService userService;
	
	@Autowired
	MediaService mediaService;
	
	@Autowired
	ServletContext context;
	
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
	@PostMapping(value="/create")
	public @ResponseBody Map<String,Object> postCreate(@RequestParam Map<String, String> params, @RequestParam("product_image") MultipartFile file) {
		Map<String,Object> map =  new HashMap<String, Object>();
		Product product  = new Product(params); 
		
       FileUploadController uploadFile = FileUploadController.getInstance();
       Map<String, Object>  servedFile = uploadFile.uploadFileHandler(file.getOriginalFilename(), file, context, "products");
       boolean success = (Boolean) (null == servedFile.get("success") ? false : servedFile.get("success")) ;
       if(success) {
    	  
    	   Media media = (Media)servedFile.get("media");    	   
    	   mediaService.save(media);
    	   productService.save(product);
    	map.put("media", servedFile.get("media"));
   		map.put("products", productService.getProducts());
   		map.put("status", 200);
   		map.put("message", "Data found");
   				
   		return map;
    	   
    	   
       }       
		map.put("status", 401);
		map.put("message", "Data not found");
				
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
