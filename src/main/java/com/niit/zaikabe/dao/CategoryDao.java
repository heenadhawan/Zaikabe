package com.niit.zaikabe.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.zaikabe.dto.Category;
@Repository("categoryDao")
public interface CategoryDao {
	boolean add(Category category);
	
	List<Category>list();
	Category get(int id);
	boolean update(Category category);
	boolean delete(Category category);
}
