package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.SupplierDao;
import com.niit.dao.UserDao;
import com.niit.dto.Category;

@Configuration
@ComponentScan(basePackages={"com.niit.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	

		@Bean(name = "dataSource")
		public DataSource getH2DataSource() 
		{
			System.out.println("Starting of the method getH2DataSource");
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("org.h2.Driver");
			dataSource.setUrl("jdbc:h2:~/test");
			dataSource.setUsername("sa");
			dataSource.setPassword("1234");
			System.out.println("Data Source Creation");
			return dataSource;
		}

		
		@Autowired
		@Bean(name="sessionFactory")
		public SessionFactory getSessionFactory(DataSource dataSource)
		{
			System.out.println("---Hibernate Properties----");
			Properties prop=new Properties();
			prop.setProperty("hibernate.hbm2ddl.auto", "update");
			prop.put("hibernate.show_sql", "true"); //optional
			prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
			System.out.println("---Hibernate Properties Created");
			
			System.out.println("---Local SessionFactory Builder Object Creation---");
			LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(getH2DataSource());
			sessionBuilder.addProperties(prop);
			System.out.println("---Factory Builder Object Created---");
			sessionBuilder.addAnnotatedClass(Category.class);
			System.out.println("Session Factory Object Creation");
			SessionFactory sessionFactory=sessionBuilder.buildSessionFactory();
			System.out.println("Session Factory Object Created");
			return sessionFactory;
		}
		
		@Autowired
		@Bean(name="transactionManager")
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
		{
			System.out.println("--Transaction manager Object Creation--");
			HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
			System.out.println("--Transaction manager Object Created--");
			return transactionManager;
		}
		@Autowired
		@Bean(name="categoryDao")
		public CategoryDao getcategoryDao(SessionFactory sessionFactory)
		{
			System.out.println("-- CategoryDAO Object Creation--");
			return new CategoryDao(sessionFactory);
		}
		@Autowired
		@Bean(name="productDao")
		public ProductDao getproductDao(SessionFactory sessionFactory)
		{
			System.out.println("-- Product DAO Object Creation--");
			return new ProductDao(sessionFactory);
		}
		@Autowired
		@Bean(name="supplierDao")
		public SupplierDao getsupplierDao(SessionFactory sessionFactory)
		{
			System.out.println("-- Supplier DAO Object Creation--");
			return new SupplierDao(sessionFactory);
		}
		@Autowired
		@Bean(name="userDao")
		public UserDao getuserDao(SessionFactory sessionFactory)
		{
			System.out.println("-- user DAO Object Creation--");
			return new UserDao();
		}
	}

		
		
		
		
		
		
	

