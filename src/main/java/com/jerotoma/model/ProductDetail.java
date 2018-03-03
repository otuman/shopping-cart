package com.jerotoma.model;

import java.util.Date;
import java.util.List;

public class ProductDetail {
	
	private int id;
	
	
	private String name;
	
	
	private String description;
	
	
	private float price;
	
	
	private int quantity;
	
	
	private Date createdOn;
	
	
	private Date updatedOn;
	
	private List<Category> categories;
	private List<Attribute> attributes;	
	private  List<Media> mediaList;
    
	private String category;
	private String attribute;

	public ProductDetail(Product product) {
		
		this.id = product.getId();
		this.name = product.getName();
		this.description=product.getDescription();
		this.price= product.getPrice();
		this.quantity =product.getQuantity();
		this.createdOn=product.getCreatedOn();
		this.updatedOn=product.getUpdatedOn();
		this.mediaList = product.getMediaList();
		this.category = "";
		this.attribute = "";
		
	}
    
	

	public List<Category> getCategories() {
		return categories;
	}


	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}


	public List<Attribute> getAttributes() {
		return attributes;
	}


	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getAttribute() {
		return attribute;
	}


	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}


	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}


	public void setMediaList(List<Media> mediaList) {
		this.mediaList = mediaList;
	}


	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getDescription() {
		return description;
	}


	public float getPrice() {
		return price;
	}


	public int getQuantity() {
		return quantity;
	}


	public Date getCreatedOn() {
		return createdOn;
	}


	public Date getUpdatedOn() {
		return updatedOn;
	}



	public List<Media> getMediaList() {
		return mediaList;
	}
	
	
	
	
}
