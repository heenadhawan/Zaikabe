package com.niit.zaikabe;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDao;

import com.niit.dto.Supplier;

public class SupplierTestCase {
	public static void main (String args[]){
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		 context.scan("com.niit.zaikabe");
		 context.refresh();
		 
		 //inserting the category object
		 System.out.println("Reach before supplier dao");
		 SupplierDao supplierDao=(SupplierDao)context.getBean("supplierDao");
		 System.out.println("Reach after supplier dao");
			//Insertion TestCase
			
		 Supplier supplier=new Supplier();
			 System.out.println("Reach after category ");
			 supplier.setName("abc");
			 supplier.setAddress("Delhi");
			 System.out.println("Reach after setSupplier ");
			 supplierDao.insertUpdateSupplier(supplier);		
			System.out.println("Supplier Inserted");
}}
