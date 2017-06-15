package com.niit.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dto.Category;

@Repository("Category Dao")
public class CategoryDao {
@Autowired
SessionFactory sessionFactory;

public CategoryDao(SessionFactory sessionFactory)
{
this .sessionFactory=sessionFactory;	
}

public void insertCategory(Category category)
{

sessionFactory.getCurrentSession().saveOrUpdate(category);

}

}