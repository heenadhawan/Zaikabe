package com.niit.zaikabe.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
@Entity
@Table
public class Supplier {
@Id
@GeneratedValue
private int id;
private String name;
private String Address;
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
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}

}
