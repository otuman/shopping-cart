package com.jerotoma.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="attributes")
public class Attribute implements Serializable {
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
	
	@Column(name="slug")
	private String slug;
	
	@Column(name="parent")
	private String parent;
	
	@Column(name="count")
	private int count;
	
	
	@OneToOne(mappedBy="attribute")
	@JsonManagedReference     //This help to solve the recursive issue with Jackson json
	private ProductAttribute productAttribute;
	
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="created_on")
	private Date createdOn;
	
	@Column(name="updated_on")
	private Date updatedOn;
	
	public Attribute() {
		
	}
	
	public Attribute(Map<String, String> params){
		
		this.count  = 0;
		this.name = params.get("name");
		this.parent = params.get("parent");
		this.slug  = params.get("slug");
		this.description  = params.get("description");
		this.createdOn  = new Date();
		this.updatedOn  = new Date();
		
	}
	
	
	
	public int getId() {
		// TODO Auto-generated method stub
		return id;
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

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public ProductAttribute getProductAttribute() {
		return productAttribute;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}



	public void setProductAttribute(ProductAttribute productAttribute) {
		this.productAttribute = productAttribute;
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

	
	
}
