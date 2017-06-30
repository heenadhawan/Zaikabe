package com.niit.zaikabe.dto;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity

public class Product 
{
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
	
 private int id;
private String code;
 private String name;
 private String  description;
 @Column(name = "category_id")
 private int Categoryid;
 @Column(name = "supplier_id")
 private int Supplierid;
 @Column(name = "price")
 private int Price;
 @Column(name = "unit")
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