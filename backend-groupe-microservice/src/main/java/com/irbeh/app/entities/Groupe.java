package com.irbeh.app.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "groupes")
public class Groupe {

	
	@Id
	private String id;
	private String nom;
	private String image;
	private String description;
	private String idUtilisateur;
	private String date;
	private String etat;
	private String domaine;
	private String pays;
	private String langue;
	private List<String> demande;
	private List<String> membre;

}
