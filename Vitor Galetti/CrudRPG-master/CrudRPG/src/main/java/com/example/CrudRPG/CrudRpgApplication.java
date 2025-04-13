package com.example.CrudRPG;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.CrudRPG", "com/example/CrudRPG/controller"})
public class CrudRpgApplication {
	public static void main(String[] args) {
		SpringApplication.run(CrudRpgApplication.class, args);
	}
}