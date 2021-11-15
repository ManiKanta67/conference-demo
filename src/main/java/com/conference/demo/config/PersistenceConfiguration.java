package com.conference.demo.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration {

	/*
	 * @Bean public DataSource dataSource() { DataSourceBuilder builder =
	 * DataSourceBuilder.create();
	 * builder.url("jdbc:mysql://localhost:3306/conference_demo");
	 * builder.username("user name"); builder.password("password");
	 * System.out.println("My custom data source bean has been initialized and set"
	 * ); return builder.build(); }
	 */
}
