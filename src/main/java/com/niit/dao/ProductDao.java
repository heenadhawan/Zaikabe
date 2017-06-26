package com.niit.dao;

import java.util.List;

import com.niit.dto.Product;

public interface ProductDao {
 
Product  get (int productId);
List<Product>list();
boolean add(Product product);
boolean delete(Product product);
boolean update(Product product);
//buisness methods
List<Product> listActiveProducts();
List<Product> listActiveProductsByCategory(int categoryid);
List<Product>getLatestActiveProducts(int count);
}
