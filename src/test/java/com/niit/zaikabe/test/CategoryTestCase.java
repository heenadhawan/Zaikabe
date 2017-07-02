package com.niit.zaikabe.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.zaikabe.dao.CategoryDao;
import com.niit.zaikabe.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDao categoryDao;
	private Category category;

	@BeforeClass

	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.zaikabe");
		context.refresh();
		categoryDao = (CategoryDao) context.getBean("categoryDao");
	}

	
	  @Test public void testAddCategory(){ 
		  category = new Category();
	 
		  category.setId(2);
		  category.setName("Sweets and Drinks");
		  category.setDescription( "Enjoy Cool food");
		  category.setImageURL("CAT_5.png");
		  category.setActive(true);
	  assertEquals("Successfully added a category inside the table!",true,categoryDao.add(category)); 
	  }

	
	 /* @Test
	 * 
	 * public void testGetCategory(){ category =categoryDao.get(2);
	 * assertEquals("Successfully fetch the single category inside the table!",
	 * "North Indian",category.getName()); } }
	 */
	/*
	 * @Test
	 * 
	 * public void testupdateCategory(){ category =categoryDao.get(2);
	 * category.setName("punjabi food"); assertEquals(
	 * "Successfully update the category inside the table!"
	 * ,true,categoryDao.update(category)); } //
	 */

	/*
	 * @Test
	  
	 * public void testDeleteCategory() {
	  category = categoryDao.get(2);
	 * 
	 * assertEquals("Successfully delete the category inside the table!",true,categoryDao.delete(category)); }
	 */
	
	  /*@Test
	 * 
	 * public void testListCategory() {
	 * 
	 * 
	 * assertEquals("Successfully fetch the list of categories inside the table!", 1, categoryDao.list().size()); }
	 */

}