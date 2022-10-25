package com.example.demo.model;


import java.util.List;

import lombok.Data;

@Data
public class UserRequestDTO {
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
    private List<String> groupe;

}
