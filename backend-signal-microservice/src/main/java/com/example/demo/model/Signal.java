package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "signalements")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Signal {
	@Id
	private String id;
	private String publicationId;
	private String commentaireId;
	private String userSignaleId;
	private String reportedUserId;
	private boolean etat;
	private String message;
	private String type;
	private String dateAjout; // YYYY-MM-DD-HH-MM-SS
	private String typeSignal; // Commentaire ou publication ou user
}
