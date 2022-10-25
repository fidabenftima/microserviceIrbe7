package com.irbeh.app.dto;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GroupeRequestDTO {

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
