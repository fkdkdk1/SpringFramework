package com.mvc.update.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:sqls/db.properties")
public class ApplicationConfig {
	
	@Value("${driver}")
	private String driver;
	
	@Value("${url}")
	private String url;
	
	@Value("${user}")
	private String username;
	
	@Value("${pw}")
	private String password;
	
	 
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		
		return new JdbcTemplate(dataSource());
	}
	
}
