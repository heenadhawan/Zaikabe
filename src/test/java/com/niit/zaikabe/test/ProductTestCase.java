package com.niit.zaikabe.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.zaikabe.dao.ProductDao;
import com.niit.zaikabe.dto.Product;

public class ProductTestCase {
private static  AnnotationConfigApplicationContext context;
private static ProductDao productDao;
private Product product;
@BeforeClass
public static void init(){
	context=new AnnotationConfigApplicationContext  ();
	context.scan("com.niit.zaikabe");
	context.refresh();
	productDao=(ProductDao)context.getBean("productDao");
	
}

@Test
public void testCRUDProduct(){
//create operation
	product= new Product();
	product.setName("Gajar Halwa");
	product.setDescription("Rich in flavour");
	product.setCategoryid(4);
	product.setPrice(90);
	product.setIs_active(true);
	product.setSupplierid(2);
	product.setQuantity(8);
	
assertEquals("Successfully added a product inside the table!",true,productDao.add(product));
	}	
	
	
	

	
	

}
