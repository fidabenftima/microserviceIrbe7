package com.irbeh.app.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.irbeh.app.entities.Groupe;


public interface GroupeRepository extends MongoRepository<Groupe, String> {
	@Query("{ 'idUtilisateur' : ?0 }")
	  List<Groupe> findByIdUser(String idUtilisateur);
	
	@Query("{ 'idPublication' : ?0 }")
	  List<Groupe> findByIdPost(String idPublication);
}
