package com.backend.webappserver.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan
@EnableJpaRepositories(basePackages = { "com.backend.webappserver.repository",
		"com.backend.webappserver.data.model" }, entityManagerFactoryRef = "locationEntityManagerFactory", transactionManagerRef = "locationTransactionManager")
public class LocationPersistenceConfig {
	@Bean
	public LocalContainerEntityManagerFactoryBean locationEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(locationDataSource());
		em.setPackagesToScan("com.backend.webappserver.data.model");
		em.setPersistenceUnitName("location_pu");

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());

		return em;
	}

	@Autowired
	private LocationDataSourceMap locationDataSourceMap;

	@Bean
	public DataSource locationDataSource() {
		LocationRoutingDatasource ds = new LocationRoutingDatasource();
		ds.setTargetDataSources(locationDataSourceMap);
		return ds;
	}

	@Bean
	public PlatformTransactionManager locationTransactionManager(
			@Qualifier("locationEntityManagerFactory") EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor locationExceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty("spring.datasource.TYPE", "com.zaxxer.hikari.HikariDataSource");
		properties.setProperty("spring.datasource.hikari.poolName", "com.zaxxer.hikari.HikariDataSource");
		properties.setProperty("spring.datasource.hikari.connection-timeout", "10000");
		properties.setProperty("spring.datasource.hikari.minimum-idle", "10");
		properties.setProperty("spring.datasource.hikari.maximum-pool-size", "100");
		properties.setProperty("spring.datasource.hikari.idle-timeout", "600000");
		properties.setProperty("spring.datasource.hikari.max-lifetime", "1800000");
		properties.setProperty("spring.datasource.hikari.auto-commit", "true");
		properties.setProperty("spring.datasource.hikari.testWhileIdle", "true");
		properties.setProperty("spring.datasource.hikari.validationQuery", "SELECT 1");
		properties.setProperty("spring.jpa.hibernate.ddl-auto", "update");
		return properties;
	}
}
