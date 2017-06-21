package com.niit.dto;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
@Entity
@Table
public class Product 
{
@Id
@GeneratedValue
	
int productid;
String productname, productdescription;
int Categoryid,Supplierid,Price,Quantity;
public int getProductid() {
	return productid;
}
public void setProductid(int productid) {
	this.productid = productid;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public String getProductdescription() {
	return productdescription;
}
public void setProductdescription(String productdescription) {
	this.productdescription = productdescription;
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

	
}
