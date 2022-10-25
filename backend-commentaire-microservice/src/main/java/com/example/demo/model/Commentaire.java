package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "commentaires")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commentaire {
	
	@Id
	private String id;
	private String contenu;
	private String date;
	private String idUtilisateur;
	private String image;
	private String idPublication;
}
