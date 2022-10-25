package com.irbeh.app.dto;


import java.util.List;

import lombok.Data;

@Data
public class GroupeResponseDTO {

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
