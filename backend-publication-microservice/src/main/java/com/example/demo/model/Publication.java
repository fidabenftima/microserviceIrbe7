package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "publications")
@Data

public class Publication {
	@Id
    private String id;
	private String date;
	private String idUtilisateur;
	private String idGroupe;
	private String image;
	private String contenu;
	private String nbPartage;
	private String actif;
}
