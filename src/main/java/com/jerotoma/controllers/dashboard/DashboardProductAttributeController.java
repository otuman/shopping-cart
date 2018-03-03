package com.jerotoma.controllers.dashboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jerotoma.model.Attribute;
import com.jerotoma.model.Category;
import com.jerotoma.services.AttributeService;


@Controller
@RequestMapping("/dashboard/products/attributes")
public class DashboardProductAttributeController {
	@Autowired
	AttributeService attributeService;
	
	
	@RequestMapping(value= {"","/"},method=RequestMethod.GET)
	public ModelAndView getIndexView() {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("dashboard/shop/attributes/index");
		view.addObject("title", "Attributes");
		return view;
		
	}
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public ModelAndView getProductView() {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("dashboard/shop/attributes/create");
		view.addObject("title", "Attributes");
		return view;
		
	}
	
	@RequestMapping("/{id}")
	public ModelAndView getShowView() {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("dashboard/shop/attributes/show");
		view.addObject("title", "Attributes");
		return view; 
		
	}
	@RequestMapping(value= {"/all"},method=RequestMethod.GET)
	public @ResponseBody Map<String, ?> getAllProducts(){
		Map<String, Object> map = new HashMap<>();
		List<Attribute> attributes = attributeService.getProductAttributes();
		
		map.put("draw", 1);
		map.put("recordsTotal", attributes.size());
		map.put("recordsFiltered", attributes.size());
		map.put("data", attributes);
		
		System.out.println(map);
		
		
		
		return map;
	}
	
	@PostMapping(value="/create")
	public @ResponseBody Map<String,Object> postCreate(@RequestParam Map<String, String> params) {
		Map<String,Object> map =  new HashMap<String, Object>();
		Attribute attribute = new Attribute(params);
		System.out.println(params);
		attributeService.save(attribute);
		return map;
	
	}
}
