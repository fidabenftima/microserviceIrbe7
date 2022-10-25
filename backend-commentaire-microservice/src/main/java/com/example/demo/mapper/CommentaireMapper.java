package com.example.demo.mapper;

import com.example.demo.DTO.CommentaireRequestDTO;
import com.example.demo.DTO.CommentaireResponseDTO;
import com.example.demo.model.Commentaire;

public interface CommentaireMapper {
	CommentaireResponseDTO commentaireToCommentaireDTO(Commentaire commentaire);
	Commentaire commentaireRequestDTOToCommentaire(CommentaireRequestDTO commentaireRequestDTO);


}
