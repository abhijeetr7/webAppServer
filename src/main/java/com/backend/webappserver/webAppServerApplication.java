package com.backend.webappserver;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.backend.webappserver.config.AuditorAwareImpl;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {
		"com.backend.webappserver.tenants" }, entityManagerFactoryRef = "tenantEntityManagerFactory", transactionManagerRef = "tenantTransactionManager")
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class webAppServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(webAppServerApplication.class, args);
	}

	@Bean
	public AuditorAware<Integer> auditorAware() {
		return new AuditorAwareImpl();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean tenantEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(tenantDataSource());
		em.setPackagesToScan("com.backend.webappserver.tenants");
		em.setPersistenceUnitName("tenant_pu");
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		return em;
	}

	@Bean
	public DataSource tenantDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/DBCompany?characterEncoding=utf8");

		dataSource.setUsername("root");
//		dataSource.setPassword("Root@123");
		 dataSource.setPassword("root");

		return dataSource;

	}			

	@Bean
	public PlatformTransactionManager tenantTransactionManager(
			@Qualifier("tenantEntityManagerFactory") EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
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

