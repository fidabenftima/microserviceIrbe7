package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Publication;


@RestController
public interface PublicationRepository extends MongoRepository<Publication, String>{
	List<Publication> findByIdUtilisateur(String idUtilisateur);
	List<Publication> findByIdGroupe(String idGroupe);
	List<Publication> findByDate(String date);
}
