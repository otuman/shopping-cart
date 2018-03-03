package com.jerotoma.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="products")
public class Product implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private float price;
	
	@Column(name="quantity")
	private int quantity;
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="created_on")
	private Date createdOn;
	
	@Column(name="updated_on")
	private Date updatedOn;
	
	@OneToMany(mappedBy="product")
	@JsonManagedReference     //This help to solve the recursive issue with Jackson json
	private List<ProductMedia> productMedia;
	
	@OneToMany(mappedBy="product")
	@JsonManagedReference     //This help to solve the recursive issue with Jackson json
	private List<ProductAttribute> productAttributes;
	
	@OneToMany(mappedBy="product")
	@JsonManagedReference     //This help to solve the recursive issue with Jackson json
	private List<ProductCategory> productCategories;
	
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "product_categories", joinColumns=@JoinColumn(name="product_id", referencedColumnName="id"), inverseJoinColumns=@JoinColumn(name="category_id",referencedColumnName="id"))
//	@JsonManagedReference     //This help to solve the recursive issue with Jackson json
//	private List<ProductCategory> productCategories;
//	
//	
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "product_attributes", joinColumns=@JoinColumn(name="product_id", referencedColumnName="id"), inverseJoinColumns=@JoinColumn(name="attribute_id",referencedColumnName="id"))
//	@JsonManagedReference     //This help to solve the recursive issue with Jackson json
//	private List<ProductAttribute> productAttributes;
	
	
	@Transient
	private  List<Media> mediaList;

	public Product(){
		
	}
	

	public Product(Map<String, String> params){
		this.name     = params.get("product_title");
		this.price    = Float.parseFloat(params.get("product_price"));
		this.quantity = Integer.parseInt(params.get("product_quantity"));
		this.description  = params.get("product_description");
		this.createdOn  = new Date();
		this.updatedOn  = new Date();
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	public void setProductMedia(List<ProductMedia> productMedia) {
		// TODO Auto-generated method stub
		this.productMedia = productMedia;

	}
	
	public List<ProductMedia> getProductMedia(){
		return productMedia;
	}


	public List<Media> getMediaList() {
		return mediaList;
	}


	public void setMediaList(List<Media> mediaList) {
		this.mediaList = mediaList;
	}


	public List<ProductCategory> getProductCategories() {
		return productCategories;
	}


	public void setProductCategories(List<ProductCategory> productCategories) {
		this.productCategories = productCategories;
	}


	public List<ProductAttribute> getProductAttributes() {
		return productAttributes;
	}


	public void setProductAttributes(List<ProductAttribute> productAttributes) {
		this.productAttributes = productAttributes;
	}
	
	
	
}
