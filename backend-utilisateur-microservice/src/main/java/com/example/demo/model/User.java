package com.example.demo.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
	@Id
	private String userId;
	private String nom;
	private String prenom;
	private String userName;
	private String sexe;
	private String dateDeNaissance;
	private String email;
	private String motPasse;
	private String nbSignal;
	private String type;
	private boolean actif;
	private String dateActivation;
	private boolean suspendu;
	private boolean payant;
	private Number numTelephone;
	private String description;
	private String poste;
	private String pays;
	private String entreprise;
	private String urlPhotoProfil;
	private String urlPhotoCouverture;
	private String dateInscription;
	private List<String> groupe;

}
