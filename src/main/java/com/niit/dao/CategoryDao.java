package com.niit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.dto.Category;
@Repository("categoryDao")
public interface CategoryDao {
	boolean add(Category category);
	
	List<Category>list();
	Category get(int id);
	boolean update(Category category);
	boolean delete(Category category);
}
