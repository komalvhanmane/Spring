package com.spring.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages = {"com.spring.jdbc.dao"})
public class jdbcConfig {

	@Bean("db")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource db = new DriverManagerDataSource();
		db.setDriverClassName("com.mysql.jdbc.Driver");
		db.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		db.setUsername("root");
		db.setPassword("123456789");
		return db;
	}

	@Bean("jb")
	public JdbcTemplate getTemplate() {
		JdbcTemplate jb=new JdbcTemplate();
		jb.setDataSource(getDataSource());
		return jb;
	}
	
//	@Bean("studentDao")
//	public StudentDaoImpl getDao() {
//		StudentDaoImpl st=new StudentDaoImpl();
//		st.setJdbcTemplate(getTemplate());
//		return st;
//	}
}
