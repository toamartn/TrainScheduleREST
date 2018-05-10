package com.intuit.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.intuit.spring.hbm.TrainScheduleMapping;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.intuit.spring.service", "com.intuit.spring.dao" , "com.intuit.spring.controller" })
// @ComponentScan(basePackages = { "com.intuit.spring"})
@EnableTransactionManagement
public class AppConfig {

	@Bean
	public DataSource dataSource() {
		BasicDataSource bds = new BasicDataSource();
		
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		bds.setUsername("testuser");
		bds.setPassword("testuser");
		bds.setInitialSize(10);
		bds.setMaxActive(15);
		return bds;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource ds) {
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setDataSource(ds);

		Properties props = new Properties();
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.format_sql", "true");
		props.put("hibernate.use_sql_comments", "true");
		props.put("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");
		props.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		
		lsfb.setHibernateProperties(props);
		 // lsfb.setMappingResources(new String[] { "Withdraw_decl.hbm.xml", "Deposit_decl.hbm.xml" });
		lsfb.setAnnotatedClasses(new Class[] {TrainScheduleMapping.class});
		return lsfb;
	}

	@Bean(autowire = Autowire.BY_TYPE)
	public HibernateTransactionManager hibTxManager() {
		return new HibernateTransactionManager();
	}

	/*@Bean(autowire = Autowire.BY_TYPE)
	public HibernateTemplate hibTemplate() {
		return new HibernateTemplate();
	}*/
}
