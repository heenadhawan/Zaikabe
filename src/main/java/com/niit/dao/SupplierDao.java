package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dto.Category;
import com.niit.dto.Supplier;
@Repository("SupplierDao")
public class SupplierDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public SupplierDao(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertUpdateSupplier(Supplier supplier)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(supplier);
	}
	
	public Supplier getSupplier(int supplierid)
	{
		Session session=sessionFactory.openSession();
		Supplier supplier=(Supplier)session.get(Supplier.class,supplierid);
		session.close();
		return supplier;
	}
	
	@Transactional
	public void deleteSupplier(Supplier supplier)
	{
		sessionFactory.getCurrentSession().delete(supplier);
	}
	
	public List<Supplier> getSupplierDetails()
	{
		Session session=sessionFactory.openSession();
		Query<Supplier> query=session.createQuery("from Supplier");
		List<Supplier> list=query.list();
		session.close();
		return list;
	}
	
}
