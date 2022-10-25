package com.example.demo.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "suivis")
@Data
public class Suivi {
	@Id
	private String id;
	private String idUtilisateurConnecte;
	private String idAmiSuivi;

}
