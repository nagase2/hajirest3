package com.example;

import javax.sql.DataSource;

import net.sf.log4jdbc.Log4jdbcProxyDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Autowired
	DataSourceProperties dataSourceProperties;
	
	DataSource dataSource;
	
	@Bean(name="a")
	DataSource realDataSource(){
		DataSourceBuilder factory = DataSourceBuilder
				.create(this.dataSourceProperties.getClassLoader())
				.url(this.dataSourceProperties.getUrl())
				.username(this.dataSourceProperties.getUsername())
				.password(this.dataSourceProperties.getPassword());
		this.dataSource =factory.build();
		return new Log4jdbcProxyDataSource(this.dataSource);
	}
	
//	@Bean(name="b")
//	DataSource dataSource(){
//		return new Log4jdbcProxyDataSource(this.dataSource);
//	}
}
