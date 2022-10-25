package com.irbeh.app.dto;



import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InteractionRequestDTO {

	
	private String id;
	private String idPublication;
	private String idCommentaire;
	private List<String> likes;
	private List<String> dislikes;
}
