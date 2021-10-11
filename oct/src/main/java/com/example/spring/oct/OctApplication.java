package com.example.spring.oct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class OctApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(OctApplication.class, args);
	}

}
