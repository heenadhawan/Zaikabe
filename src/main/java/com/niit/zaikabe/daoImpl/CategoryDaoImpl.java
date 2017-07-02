package com.niit.zaikabe.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.zaikabe.dao.CategoryDao;
import com.niit.zaikabe.dto.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	/*
	 * private static List<Category> categories = new ArrayList<Category>();
	 * 
	 * static{ Category category = new Category(); //adding first category
	 * 
	 * category = new Category();
	 * 
	 * category.setId(1); category.setName("North Indian");
	 * category.setDescription("Enjoy north indian food");
	 * category.setImageURL("CAT_1.png");
	 * 
	 * categories.add(category);
	 * 
	 * //adding second category category = new Category();
	 * 
	 * category.setId(2); category.setName("South Indian");
	 * category.setDescription("Enjoy south indian food");
	 * category.setImageURL("CAT_2.png"); categories.add(category);
	 * 
	 * //adding 3 category
	 * 
	 * category = new Category();
	 * 
	 * category.setId(3); category.setName("chineese"); category.setDescription(
	 * "Enjoy chineese food"); category.setImageURL("CAT_3.png");
	 * categories.add(category); //adding 4 category category = new Category();
	 * 
	 * category.setId(4); category.setName("Sweetsand drinks");
	 * category.setDescription("Enjoy our special drinks and desserts");
	 * category.setImageURL("CAT_4.png"); categories.add(category); }
	 * 
	 * 
	 * 
	 */ 
	  
	 public boolean add(Category category) {
	  try{
	   //add the category to the database table
	 sessionFactory.getCurrentSession().save(category); return true; } catch (Exception ex){ ex.printStackTrace(); return false; }}
	 

	public List<Category> list() {
		String  selectActiveCategory = "FROM Category WHERE  active=:active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active",true);
		return  query.getResultList();
	}

	// getting single category based on id
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	public boolean update(Category category) {
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean delete(Category category) {
		category.setActive(false);
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	
	}

	

}
