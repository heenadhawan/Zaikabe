package com.niit.zaikabe.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.zaikabe.dao.ProductDao;
import com.niit.zaikabe.dto.Product;
@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;
	/*
	 * SINGLE
	 * 
	 */
	public Product get(int productId) {
		try{
			return sessionFactory
					.getCurrentSession()
					.get(Product.class,Integer.valueOf(productId));
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			
		}
		return null;
	}
	/*
	 * list
	 */

	public List<Product> list() {
		return sessionFactory
				.getCurrentSession()
				.createQuery("FROM PRODUCT",Product.class)
		.getResultList();
		
			}

	

	/*
	 * insert
	 * 
	 */
	public boolean add(Product product) {
		try{
			sessionFactory
			.getCurrentSession()
			.persist(product);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}	
		return false;
	}
	
	/*
	 * delete
	 * 
	 */
	public boolean delete(Product product) {
		try{
			product.setIs_active(false);
			//call update method
			return this.update(product);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}	
		return false;
	}
	/*
	 * update
	 * 
	 */
	public boolean update(Product product) {
		try{
			sessionFactory
			.getCurrentSession()
			.update(product);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}	
		return false;
	}

	public List<Product> listActiveProducts() {
String  selectActiveProducts ="FROM PRODUCT WHERE active=:active";

		return sessionFactory
				.getCurrentSession()
				.createQuery(selectActiveProducts,Product.class)
				.setParameter("active",true)
				.getResultList();
		
		
		
	}

	public List<Product> listActiveProductsByCategory(int categoryid) {
		String  selectActiveProductsByCategory ="FROM PRODUCT WHERE active=:active ANDcategoryId=:categoryid";

		return sessionFactory
				.getCurrentSession()
				.createQuery( selectActiveProductsByCategory,Product.class)
				.setParameter("active",true)
				.setParameter("categoryId", categoryid)
				.getResultList();
		
		
	}

	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactory
				.getCurrentSession()
				.createQuery("FROM PRODUCT WHERE active = :active ORDER BY id",Product.class)
				.setParameter("active",true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();	
	}

}
