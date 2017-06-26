package com.niit.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
@Entity
@Table
public class Category {
/*
 * Private fields
 */
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
private int id;
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", Description=" + Description + ", imageURL=" + imageURL
				+ ", active=" + active + "]";
	}
	private String name;
	private String Description;
	@Column(name = "image_url")
	private String imageURL;
	@Column(name = "is_active")
	private  boolean active = true;
	
	
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
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}




