package com.jerotoma.controllers.dashboard;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.annotation.MultipartConfig;

import com.jerotoma.helpers.FileUploadController;
import com.jerotoma.model.Media;
import com.jerotoma.model.Product;
import com.jerotoma.model.ProductMedia;
import com.jerotoma.model.User;
import com.jerotoma.services.MediaService;
import com.jerotoma.services.ProductMediaService;
import com.jerotoma.services.ProductService;
import com.jerotoma.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@MultipartConfig
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
	
	@Autowired
	ProductMediaService productMediaService;
	
	@RequestMapping(value= {"","/"},method=RequestMethod.GET)
	public ModelAndView getIndexView(Principal principal) {
		String username = principal.getName();
		User user = userService.getCurrentUser(username);
		List<Product> products = productService.getProducts();
		
		ModelAndView view = new ModelAndView();
		view.setViewName("dashboard/pages/products/index");
		view.addObject("products", products);
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
    	   int mediaID   = mediaService.save(media);
    	   productService.save(product);
    	  
       //Initialize ProductMedia Object, and set product media ids
    	   ProductMedia productMedia = new ProductMedia();
    	   productMedia.setProduct(product);
    	   productMedia.setMediaId(mediaID);
    	  
       //Save ProductMedia in the database
    	   @SuppressWarnings("unused")
		   int productMediaID  = productMediaService.save(productMedia);
    	   productMedia = null;
    	   
    	   List<Product> products = new ArrayList<Product>(); 
    	  
    	   for(Product p : productService.getProducts() ) {
    		  List<Media> mediaList  = new ArrayList<Media>();
    		  for(ProductMedia pm : p.getProductMedia()){
    			  Media m = mediaService.getMedia(pm.getMediaId());
    			  System.out.println(m.getTitle());
    			  mediaList.add(m);    			
    		   }
    		   p.setMediaList(mediaList);
    		   products.add(p);
    	   }
    	   for(Product prod : products){
    		   System.out.println("Product Name : "+prod.getName());
    		   System.out.println("Media List : "+prod.getMediaList());
    		   for(Media md : prod.getMediaList()) {
    			   System.out.println("SRC Name : "+ md.getSrc());
    		   }
    		   
    	   }
    	  
    	
    	  
    	  map.put("productMedia", productMediaService.getProductMedia(productMediaID));
    	  map.put("media", servedFile.get("media"));
   		  map.put("products", products);
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
	
	
	@RequestMapping(value= {"/all"},method=RequestMethod.GET)
	public @ResponseBody Map<String, ?> getAllProducts(){
		Map<String, Object> map = new HashMap<>();
		List<Product> products = productService.getProducts();
		
		for(Product p: products) {
			
			System.out.println( "Otoman "+ p.getProductMedia());
		}
		map.put("draw", 1);
		map.put("recordsTotal", products.size());
		map.put("recordsFiltered", products.size());
		map.put("data", products);
		
		System.out.println(map);
		
		
		
		return map;
	}
	
	
	
	
	
}
