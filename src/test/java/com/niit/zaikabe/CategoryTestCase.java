package com.niit.zaikabe;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDao;
import com.niit.dto.Category;
public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDao categoryDao;
    private Category category;

@BeforeClass

 public static void init(){
   context = new AnnotationConfigApplicationContext();
   context.scan("com.niit.zaikabe");
   context.refresh();
   categoryDao =(CategoryDao)context.getBean("categoryDao");
}
     @Test
	public void testAddCategory(){
		category = new Category();
	
		category.setName("North Indian");
		category.setDescription("Enjoy north indian food");
		category.setImageURL("CAT_1.png");
		
     assertEquals("Successfully added a category inside the table!",true,categoryDao.add(category));
	}
	

}	