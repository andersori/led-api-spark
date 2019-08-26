package io.andersori.led.api;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "io.andersori.led.api")
public class JpaConfiguration {
				
	@Bean
	public DataSource getDataSource() {
		return null;
	}
	
}
