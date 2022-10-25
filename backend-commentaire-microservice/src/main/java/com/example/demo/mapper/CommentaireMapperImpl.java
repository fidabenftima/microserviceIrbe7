package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.CommentaireRequestDTO;
import com.example.demo.DTO.CommentaireResponseDTO;
import com.example.demo.model.Commentaire;

@Component
public class CommentaireMapperImpl implements CommentaireMapper {

	@Override
	public CommentaireResponseDTO commentaireToCommentaireDTO(Commentaire commentaire) {
		 if (commentaire == null ) {
	            return null;
	        }

		 CommentaireResponseDTO commentaireResponseDTO = new CommentaireResponseDTO();

	     commentaireResponseDTO.setId(commentaire.getId() );
	     commentaireResponseDTO.setContenu(commentaire.getContenu() );
	     commentaireResponseDTO.setDate( commentaire.getDate() );
	     commentaireResponseDTO.setIdUtilisateur( commentaire.getIdUtilisateur() );
	     commentaireResponseDTO.setIdPublication( commentaire.getIdPublication() );
	     commentaireResponseDTO.setImage( commentaire.getImage() );

	        return commentaireResponseDTO;
	}

	@Override
	public Commentaire commentaireRequestDTOToCommentaire(CommentaireRequestDTO commentaireRequestDTO) {
		if (commentaireRequestDTO == null ) {
            return null;
        }

		Commentaire commentaire = new Commentaire();

	    commentaire.setId( commentaireRequestDTO.getId() );
	    commentaire.setContenu( commentaireRequestDTO.getContenu() );
	    commentaire.setDate( commentaireRequestDTO.getDate() );
	    commentaire.setIdUtilisateur( commentaireRequestDTO.getIdUtilisateur() );
	    commentaire.setIdPublication( commentaireRequestDTO.getIdPublication() );
	    commentaire.setImage( commentaireRequestDTO.getImage() );
        return commentaire;
	}

}
