package com.irbeh.app.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "interactions")
public class Interaction {
	
	@Id
	private String id;
	private String idPublication;
	private String idCommentaire;
	private List<String> likes;
	private List<String> dislikes;
	

}
