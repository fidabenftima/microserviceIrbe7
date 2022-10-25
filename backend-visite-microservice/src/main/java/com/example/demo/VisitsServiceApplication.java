package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.demo.repository.VisitRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = VisitRepository.class)
public class VisitsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VisitsServiceApplication.class, args);
	}

}
