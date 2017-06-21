package com.niit.zaikabe;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDao;
import com.niit.dto.Product;



public class ProductTestCase {
	public static void main (String args[]){
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	 context.scan("com.niit.zaikabe");
	 context.refresh();
	 
	 //inserting the category object
	 System.out.println("Reach before product dao");
	 ProductDao productDao=(ProductDao)context.getBean("productDao");
	 System.out.println("Reach after  product dao");
		//Insertion TestCase
		
		Product product=new Product();
		
		product.setProductname("dal makhni");
		product.setProductdescription("Enjoy Food");
		

		productDao.insertUpdateProduct(product);		
		System.out.println("product Inserted");
		
		//Retrieval TestCase
		
		/*Product product=productDao.getProduct(2);
		System.out.println("Product Name:"+product.getCatname());
		System.out.println("Product Description:"+product.getproductdesc());*/
		
		//Deletion TestCase
		/*product product=productDao.getCategory(2);
		productDao.deleteProduct(product);
		System.out.println("The product Deleted");*/
		
		//Retrieving the Data
		
		/*List<Product> list=productDao.getProductDetails();
		
		for(Product product:list)
		{
			System.out.println(Product.getproductname()+":"+product.Productdescription()+":"+category.getCatdesc());
		}*/
		
		//Update the Product
		/*Product product=ProductDao.getproduct(3);
		Product.setName("South Indian");
		ProductDao.insertUpdateProduct(product);
		System.out.println("The Product Updated");
		
	}*/

	}}
