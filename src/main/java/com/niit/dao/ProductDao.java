package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dto.Category;
import com.niit.dto.Product;
@Repository("ProductDao")
public class ProductDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public ProductDao(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertUpdateProduct(Product product)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
	}
	
	public Product getProduct(int productid)
	{
		Session session=sessionFactory.openSession();
		Product product=(Product) session.get(Product.class,productid);
		session.close();
		return product;
	}
	
	@Transactional
	public void deleteProduct(Product product)
	{
		sessionFactory.getCurrentSession().delete(product);
	}
	
	public List<Product> getProductDetails()
	{
		Session session=sessionFactory.openSession();
		Query<Product> query=session.createQuery("from Product");
		List<Product> list=query.list();
		session.close();
		return list;
	}
	
}
