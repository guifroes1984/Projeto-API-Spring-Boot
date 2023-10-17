package com.example.projeto.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.projeto.api.config.property.ApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(ApiProperty.class)
public class ProjetoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoApiApplication.class, args);
	}

}
