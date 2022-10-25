package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Suivi;


@RestController
public interface SuiviRepository extends MongoRepository<Suivi, String>{
	List<Suivi> findByIdUtilisateurConnecte(String idUtilisateurConnecte);
	List<Suivi> findByIdAmiSuivi(String idAmiSuivi);
	List<Suivi> findByIdAmiSuiviAndIdUtilisateurConnecte(String idAmiSuivi, String idUtilisateurConnecte);

}
