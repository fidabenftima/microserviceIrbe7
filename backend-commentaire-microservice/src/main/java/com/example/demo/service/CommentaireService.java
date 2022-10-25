package com.example.demo.service;

import java.util.List;

import com.example.demo.DTO.CommentaireRequestDTO;
import com.example.demo.DTO.CommentaireResponseDTO;



public interface CommentaireService {
	 List<CommentaireResponseDTO> getCommentaire();
	 CommentaireResponseDTO getCommentaire(String id);
	 CommentaireResponseDTO save(CommentaireRequestDTO commentaireRequestDTO);
	 void deleteCommentaire( String id);
	 CommentaireResponseDTO update(CommentaireRequestDTO commentaireRequestDTO);
	 List <CommentaireResponseDTO> getCommentaireByPostId(String id);



}
