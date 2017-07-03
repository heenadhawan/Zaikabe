package com.niit.zaikabe.dto;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
@Entity

public class Product 
{
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
	
 private int id;
private String code;
@NotBlank (message="please enter the product name!")	
 private String name;
@NotBlank (message="please enter the product description!")
 private String  description;
 @Column(name = "category_id")
 private int Categoryid;
 @Column(name = "supplier_id")
 private int Supplierid;
 @Column(name = "price")
 @Min(value=10,message="The price cannot less than10 ")
 private int Price;
 @Column(name = "unit")
 @Min(value=1,message="the Qantity must be 1 or more than 1")
 private int Quantity;
 private int purchases,views;
 private boolean is_active;
public int getId() {
	return id;
}

//default constructor
public Product(){
	this.code = "PRD"+ UUID.randomUUID().toString().substring(26).toUpperCase();
}

//generate getter and setters
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
public int getCategoryid() {
	return Categoryid;
}
public void setCategoryid(int categoryid) {
	Categoryid = categoryid;
}
public int getSupplierid() {
	return Supplierid;
}
public void setSupplierid(int supplierid) {
	Supplierid = supplierid;
}
public int getPrice() {
	return Price;
}
public void setPrice(int price) {
	Price = price;
}
public int getQuantity() {
	return Quantity;
}
public void setQuantity(int quantity) {
	Quantity = quantity;
}
public int getPurchases() {
	return purchases;
}
public void setPurchases(int purchases) {
	this.purchases = purchases;
}
public int getViews() {
	return views;
}
public void setViews(int views) {
	this.views = views;
}
public boolean isIs_active() {
	return is_active;
}
public void setIs_active(boolean is_active) {
	this.is_active = is_active;
}
 

 
 
 
 
 
}