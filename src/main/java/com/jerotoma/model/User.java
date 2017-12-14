package com.jerotoma.model;

import java.io.Serializable;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="role_id")
	private int roleID;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
		
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="created_on")
	private Date createdOn;
	
	@Column(name="updated_on")
	private Date updatedOn;
	
	public User() {
		
	}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;		
	}
	public User(Map<String, String> params) {
		super();
		this.username = params.get("email");
		this.password = params.get("password");
		this.firstName= params.get("first_name");
		this.lastName = params.get("last_name");
		this.createdOn = new Date();
		this.updatedOn = new Date();
		
		
		System.out.println(params);
	}
	public User(String username, String password, String firstName, String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.firstName= firstName;
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	private int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	private Date getCreatedOn() {
		return createdOn;
	}

	private void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	private Date getUpdatedOn() {
		return updatedOn;
	}

	private void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	private int getRoleID(){
		return roleID;
	}

	private void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	

}
