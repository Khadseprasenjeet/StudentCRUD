package com.stu.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.context.annotation.Bean;

import com.stu.main.Utility.EntityDTOConvertor;

@SpringBootApplication
public class StudentCrudApplication {

	@Bean
	public EntityDTOConvertor AuthenticationFilter() {
		return new EntityDTOConvertor();
	}


	public static void main(String[] args) {
		SpringApplication.run(StudentCrudApplication.class, args);
	}

}
