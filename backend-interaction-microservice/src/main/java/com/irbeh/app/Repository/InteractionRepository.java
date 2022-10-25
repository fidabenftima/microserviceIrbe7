package com.irbeh.app.Repository;




import org.springframework.data.mongodb.repository.MongoRepository;

import com.irbeh.app.entities.Interaction;

public interface InteractionRepository extends MongoRepository<Interaction, String> {
	
	Interaction findByIdPublication(String idPublication);

}
