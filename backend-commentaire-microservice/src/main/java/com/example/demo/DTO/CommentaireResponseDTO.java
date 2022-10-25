package com.example.demo.DTO;

import org.springframework.data.annotation.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentaireResponseDTO {
	
	@Id
	private String id;
	private String contenu;
	private String date;
	private String idUtilisateur;
	private String idPublication;
	private String image;

}
