package com.springsecurity.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.springsecurity")
@PropertySource("classpath:persistence-mysql.properties")
public class ApplicationConfig {

	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public DataSource securityDataSource() {
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch(PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		setJDBCConnectionProperties(securityDataSource);
		setConnectionPoolProperties(securityDataSource);
		return securityDataSource;
	}
	
	private void setJDBCConnectionProperties(ComboPooledDataSource securityDataSource) {
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
	}

	private void setConnectionPoolProperties(ComboPooledDataSource securityDataSource) {
		
		securityDataSource.setInitialPoolSize(parseToInt("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(parseToInt("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(parseToInt("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(parseToInt("connection.pool.maxIdleTime"));
	}

	private int parseToInt(String property) {
		return Integer.parseInt(env.getProperty(property));
	}
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
}
