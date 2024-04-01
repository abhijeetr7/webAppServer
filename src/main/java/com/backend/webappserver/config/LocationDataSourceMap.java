package com.backend.webappserver.config;

import java.util.HashMap;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.backend.webappserver.tenants.Tenant;
import com.backend.webappserver.tenants.TenantRepository;
import com.zaxxer.hikari.HikariDataSource;

@SuppressWarnings("serial")
@Component
public class LocationDataSourceMap extends HashMap<Object, Object> implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public Object get(Object key) {
		Object value = super.get(key);
		if (value == null) {

			// Can't autowire this because it apparently creates a chicken/egg
			// problem during configuration.
			TenantRepository repo = applicationContext.getBean(TenantRepository.class);

			Tenant tenant = repo.findByCompanyCode((String) key);
			if (tenant != null) {
				HikariDataSource dataSource = new HikariDataSource();
				dataSource.setDriverClassName("com.mysql.jdbc.Driver");

				dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/" + tenant.getCompanyDB());
				dataSource.setUsername("root");

//				dataSource.setPassword("Root@123");
				 dataSource.setPassword("root");
				dataSource.setPoolName(tenant.getCompanyDB());
				dataSource.setMaxLifetime(1800000);
				dataSource.setAutoCommit(true);

				// HikariCP settings
				// Maximum number of actual connection in the pool
				dataSource.setMaximumPoolSize(150);

				// Minimum number of idle connections in the pool
				dataSource.setMinimumIdle(10);

				// Maximum waiting time for a connection from the pool
				dataSource.setConnectionTimeout(10000);

				// Maximum time that a connection is allowed to sit idle in the pool
				dataSource.setIdleTimeout(600000);
				value = dataSource;
				super.put(key, value);
			}else {
				HikariDataSource dataSource = new HikariDataSource();
				dataSource.setDriverClassName("com.mysql.jdbc.Driver");
				dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/WebApp");
				dataSource.setUsername("root");
				dataSource.setPassword("root");
				dataSource.setPoolName("connection");

				// HikariCP settings
				// Maximum number of actual connection in the pool
				dataSource.setMaximumPoolSize(150);

				// Minimum number of idle connections in the pool
				dataSource.setMinimumIdle(10);

				// Maximum waiting time for a connection from the pool
				dataSource.setConnectionTimeout(20000);

				// Maximum time that a connection is allowed to sit idle in the pool
				dataSource.setIdleTimeout(300000);
				value = dataSource;
				super.put(key, value);
			}
		}
		return value;
	}

}
