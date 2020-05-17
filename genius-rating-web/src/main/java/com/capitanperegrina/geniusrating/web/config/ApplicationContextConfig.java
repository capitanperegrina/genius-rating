package com.capitanperegrina.geniusrating.web.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource(value={"classpath:genius-rating-application.properties"})
public class ApplicationContextConfig {
	
	@Autowired(required=false)
	private Environment env;

	@Value("${init-db:false}")
	private String initDatabase;

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(this.env.getProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(this.env.getProperty("spring.datasource.url"));
		dataSource.setUsername(this.env.getProperty("spring.datasource.username"));
		dataSource.setPassword(this.env.getProperty("spring.datasource.password"));
		return dataSource;
	}
	
	@Bean(name = "messageSource")
	public ReloadableResourceBundleMessageSource messageSource() {
	    ReloadableResourceBundleMessageSource messageBundle = new ReloadableResourceBundleMessageSource();
	    messageBundle.setBasenames("classpath:genius-rating-messages, classpath:simple-user-messages");
	    messageBundle.setDefaultEncoding("UTF-8");
	    return messageBundle;
	}
}