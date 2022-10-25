package com.irbeh.app.mappers;

import org.springframework.stereotype.Component;

import com.irbeh.app.dto.InteractionRequestDTO;
import com.irbeh.app.dto.InteractionResponseDTO;
import com.irbeh.app.entities.Interaction;

@Component
public class IInteractionMapper implements InteractionMapper  {

	@Override
	public InteractionResponseDTO InteractionToInteractionDTO(Interaction interaction) {
		// TODO Auto-generated method stub
		if (interaction == null ) {
            return null;
        }

		InteractionResponseDTO interactionResponseDTO = new InteractionResponseDTO();

		interactionResponseDTO.setId( interaction.getId() );
		interactionResponseDTO.setIdPublication( interaction.getIdPublication() );
		interactionResponseDTO.setIdCommentaire( interaction.getIdCommentaire() );
		interactionResponseDTO.setLikes( interaction.getLikes() );
		interactionResponseDTO.setDislikes( interaction.getDislikes() );	

		

        return interactionResponseDTO;
	}

	@Override
	public Interaction InteractionRequestDTOToInteraction(InteractionRequestDTO interactionRequestDTO) {
		// TODO Auto-generated method stub
		if (interactionRequestDTO == null ) {
            return null;
        }

		Interaction interaction = new Interaction();

		interaction.setId( interactionRequestDTO.getId() );
		interaction.setIdPublication( interactionRequestDTO.getIdPublication() );		
		interaction.setIdCommentaire( interactionRequestDTO.getIdCommentaire() );
		interaction.setLikes( interactionRequestDTO.getLikes() );
		interaction.setDislikes( interactionRequestDTO.getDislikes() );	

        return interaction;
	}

}
