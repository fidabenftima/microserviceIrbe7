package com.irbeh.app.mappers;

import com.irbeh.app.dto.InteractionRequestDTO;
import com.irbeh.app.dto.InteractionResponseDTO;
import com.irbeh.app.entities.Interaction;

public interface InteractionMapper {

	
	InteractionResponseDTO InteractionToInteractionDTO(Interaction interaction);
	Interaction InteractionRequestDTOToInteraction(InteractionRequestDTO interactionRequestDTO);
}
