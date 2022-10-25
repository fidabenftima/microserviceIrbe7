package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;

@RestController
public interface UserRepository extends MongoRepository<User, String> {
List<User> findByUserName(String userName);
List<User> findByEmail (String email);
List<User> findBySexe (String sexe);
List<User> findByGroupe (String groupe);
}
