package com.carol.jpaboot01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication

public class JpaBoot01Application {

	public static void main(String[] args) {

		SpringApplication.run(JpaBoot01Application.class, args);
	}

}
