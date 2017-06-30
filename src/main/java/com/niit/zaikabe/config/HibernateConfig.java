package com.niit.zaikabe.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;




@Configuration
@ComponentScan(basePackages={"com.niit.zaikabe.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	

	public final static String DATABASE_URL="jdbc:h2:tcp://localhost/~/zaika";
	public final static String DATABASE_DRIVER="org.h2.Driver";
	public final static String DATABASE_DIALECT="org.hibernate.dialect.H2Dialect";
	public final static String DATABASE_USERNAME="sa";
	public final static String DATABASE_PASSWORD="1234";
	
	//DataSource bean
	@Bean(name="datasouce")
	public DataSource getDataSource(){
		BasicDataSource basicDataSource = new BasicDataSource();
		
		basicDataSource.setDriverClassName(DATABASE_DRIVER);
		basicDataSource.setUsername(DATABASE_USERNAME);
		basicDataSource.setUrl(DATABASE_URL);
		basicDataSource.setPassword(DATABASE_PASSWORD);
		return basicDataSource;
	}
		
	//SessionFactory bean
		@Bean
		public SessionFactory getSessionFactory(DataSource dataSource){
			LocalSessionFactoryBuilder sessionFactory = new LocalSessionFactoryBuilder(dataSource);
			sessionFactory.addProperties(getHibernateProperties());
			sessionFactory.scanPackages("com.niit.zaikabe.dto");
			return sessionFactory.buildSessionFactory();
		}
		
		public Properties getHibernateProperties(){
			Properties properties = new Properties();		
			properties.put("hibernate.dialect", DATABASE_DIALECT);
			properties.put("hibernate.show_sql", "true");
			properties.put("hibernate.format_sql", "true");
			properties.put("hibernate.hbm2ddl.auto", "update");
			return properties;
		}
		
		//Transaction Manager bean
		@Bean
		public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory){
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
			return transactionManager;
		}

			}
	
		
		
		
	

