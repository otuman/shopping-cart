package com.jerotoma.model;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="media")
public class Media implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="absolutePath")
	private String absolutPath;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="src")
	private String src;
	
	@Column(name="type")
	private String type;
	
	@Column(name="size")
	private long size;
	
	public Media() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public static BufferedImage processFile(byte[] bytes) {
		    InputStream in = new ByteArrayInputStream(bytes);
	    
			try {
				return ImageIO.read(in);				
			
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	        return null;
	}

	public void setSize(long size) {
		
		this.size = size;
	}
   public long getSize() {
		return size;
	}

	public String getAbsolutPath() {
		return absolutPath;
	}
	
	public void setAbsolutPath(String absolutPath) {
		this.absolutPath = absolutPath;
	}

}
