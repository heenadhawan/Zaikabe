package com.niit.zaikabe;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDao;
import com.niit.dto.Category;



public class CategoryTestCase {
	public static void main (String args[]){
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	 context.scan("com.niit.zaikabe");
	 context.refresh();
	 
	 //inserting the category object
	 System.out.println("Reach before category dao");
	 CategoryDao categoryDao=(CategoryDao)context.getBean("categoryDao");
	 System.out.println("Reach after category dao");
		//Insertion TestCase
		
		Category category=new Category();
		 System.out.println("Reach after category ");
		category.setName("North Indian");
		category.setDescription("Enjoy our North Indian Food");
		 System.out.println("Reach after setcategory ");
		categoryDao.insertUpdateCategory(category);		
		System.out.println("Category Inserted");
		
		//Retrieval TestCase
		
		/*Category category=categoryDao.getCategory(2);
		System.out.println("Category Name:"+category.getCatname());
		System.out.println("Category Description:"+category.getCatdesc());*/
		
		//Deletion TestCase
		/*Category category=categoryDao.getCategory(2);
		categoryDao.deleteCategory(category);
		System.out.println("The Category Deleted");*/
		
		//Retrieving the Data
		
		/*List<Category> list=categoryDao.getCategoryDetails();
		
		for(Category category:list)
		{
			System.out.println(category.getCatid()+":"+category.getCatname()+":"+category.getCatdesc());
		}*/
		
		//Update the Category
		/*Category category=categoryDao.getCategory(3);
		category.setName("South Indian");
		categoryDao.insertUpdateCategory(category);
		System.out.println("The Category Updated");
		
	}*/

	}}



	 
	 

	 
	 
	 
	 
	 

