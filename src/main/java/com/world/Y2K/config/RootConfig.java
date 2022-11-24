package com.world.Y2K.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@ComponentScan(basePackages = {"com.world.Y2K"})
public class RootConfig {
	

	 @Autowired
	 private ApplicationContext applicationContext;
	
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		return new SqlSessionTemplate((SqlSessionFactory) sqlSessionFactoryBean());
		
	}
	
	
	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setConfigLocation(applicationContext.getResource("classpath:/mybatis-config.xml"));
		sqlSessionFactory.setDataSource(dataSource());
		return (SqlSessionFactory)sqlSessionFactory.getObject();
	}
	
	
	
	@Bean 
	public DataSourceTransactionManager transactionManager() {
		DataSourceTransactionManager transaction = new DataSourceTransactionManager();
		transaction.setDataSource(dataSource());
		return transaction;
	}
	
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		basicDataSource.setUsername("Y2K");
		basicDataSource.setPassword("Y2K");
		return basicDataSource;
	}
	
//	@Bean
//	 public SqlSessionFactory sqlSessionFactory() throws Exception {
//		 SqlSessionFactoryBean sqlSessionFactory=new SqlSessionFactoryBean();
//		 sqlSessionFactory.setDataSource(dataSource());
//	        
//		 return (SqlSessionFactory) sqlSessionFactory.getObject();
//	 }
	
	
//	  @Bean
//		public DataSource dataSource() {
//			DriverManagerDataSource mysql = new DriverManagerDataSource();
//			mysql.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//			mysql.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
//			mysql.setUsername("Y2K");
//			mysql.setPassword("Y2K");
//			return mysql;
//		}

	@Bean
	public BCryptPasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setMaxUploadSize(100000000);
		commonsMultipartResolver.setMaxInMemorySize(100000000);
		return commonsMultipartResolver;
	}
}
