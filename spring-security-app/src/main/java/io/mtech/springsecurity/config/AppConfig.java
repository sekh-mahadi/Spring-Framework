package io.mtech.springsecurity.config;

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
@ComponentScan(basePackages = "io.mtech.springsecurity")
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfig {

	// set up variable to hold the properties
	@Autowired
	private Environment env;
	// Set up a logger for diagnostics
	Logger logger = Logger.getLogger(getClass().getName());

// difine a bean for viewResolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

//Difine a bean for our security datasource
	@Bean
	public DataSource securityDataSource() {
		// create connection pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

		// set the jdbc driver class
		try {
			securityDataSource.setDriverClass((env.getProperty("jdbc.driver")));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException();
		}

		// log the connection props
		// just to make sure we are REALLY reading data from properties file
		logger.info(">>> Jdbc.url= " + env.getProperty("jdbc.url"));
		logger.info(">>> Jdbc.user= " + env.getProperty("jdbc.user"));

		// set the database connection
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));

		// set a connection pool props
		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

		return securityDataSource;

	}

	// need a helper method
	// read environment property and convert to int

	private int getIntProperty(String propName) {
		String propVal = env.getProperty(propName);
		// now convert to int
		int intPropVal = Integer.parseInt(propVal);
		return intPropVal;
	}

}
