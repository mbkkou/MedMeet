package com.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@EnableTransactionManagement
public class MedMeetApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedMeetApplication.class, args);
	}
	@Configuration

	public class CorsConfig implements WebMvcConfigurer {
	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	                .allowedOriginPatterns("http://localhost:4200")
	                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
	                .allowedHeaders("*")
	                .allowCredentials(true)
	                .maxAge(3600);
	    }
	}


}
