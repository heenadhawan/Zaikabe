package com.niit.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
@Entity
@Table
public class Category {
/*
 * Private fields
 */
	@Id
	@GeneratedValue
private int id;
private String name;
private String Description;

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

}


