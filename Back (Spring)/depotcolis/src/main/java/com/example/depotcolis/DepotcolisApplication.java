package com.example.depotcolis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DepotcolisApplication {
    public static void main(String[] args) {
        SpringApplication.run(DepotcolisApplication.class, args);
    }
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*") // Remplacez avec l'URL de votre application 
						.allowedMethods("GET", "POST", "PUT", "DELETE");
			}
		};
	}
	
}
