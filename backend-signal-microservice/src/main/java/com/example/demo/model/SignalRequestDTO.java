package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignalRequestDTO {
	
	private String id;
	private String publicationId;
	private String commentaireId;
	private String userSignaleId;
	private String reportedUserId;
	private boolean etat;
	private String message;
	private String type;
	private String dateAjout; // YYYY-MM-DD--HH:MM:SS
	private String typeSignal; // Commentaire ou publication

}
