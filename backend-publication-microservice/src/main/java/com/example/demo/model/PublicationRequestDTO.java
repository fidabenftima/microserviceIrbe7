package com.example.demo.model;


import lombok.Data;

@Data
public class PublicationRequestDTO {
	private String id;
	private String date;
	private String idUtilisateur;
	private String idGroupe;
	private String image;
	private String contenu;
	private String nbPartage;
	private String actif;
}
