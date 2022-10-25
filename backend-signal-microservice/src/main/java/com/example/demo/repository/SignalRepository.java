package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Signal;

@RestController

public interface SignalRepository extends MongoRepository<Signal, String> {

}
