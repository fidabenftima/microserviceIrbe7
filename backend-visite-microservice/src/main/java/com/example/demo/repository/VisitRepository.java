package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Visit;

@RestController
public interface VisitRepository extends MongoRepository<Visit, String> {
	
List<Visit> findByDate(String date);
}
