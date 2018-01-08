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
	
	
	private List<ProductMedia> productMedia;
	
	
	private  List<Media> mediaList;


	public ProductDetail(Product product) {
		
		this.id = product.getId();
		this.name = product.getName();
		this.description=product.getDescription();
		this.price= product.getPrice();
		this.quantity =product.getQuantity();
		this.createdOn=product.getCreatedOn();
		this.updatedOn=product.getUpdatedOn();
		this.mediaList = product.getMediaList();
		this.productMedia=product.getProductMedia();
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


	public List<ProductMedia> getProductMedia() {
		return productMedia;
	}


	public List<Media> getMediaList() {
		return mediaList;
	}
	
	
	
	
}
