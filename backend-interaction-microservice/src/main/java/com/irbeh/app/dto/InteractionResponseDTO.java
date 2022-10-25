package com.irbeh.app.dto;


import java.util.List;

import lombok.Data;

@Data
public class InteractionResponseDTO {

	
	private String id;
	private String idPublication;
	private String idCommentaire;
	private List<String> likes;
	private List<String> dislikes;}
