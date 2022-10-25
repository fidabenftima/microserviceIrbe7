package com.example.demo.repository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.model.Commentaire;
@RestController
public interface CommentaireRepository extends MongoRepository<Commentaire, String>{

@Query("{ 'idPublication' : ?0 }")
	  List<Commentaire> findByIdPost(String idPublication);
}
