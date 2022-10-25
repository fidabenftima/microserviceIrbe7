package com.irbeh.app.services;

import java.util.List;


import com.irbeh.app.dto.InteractionRequestDTO;
import com.irbeh.app.dto.InteractionResponseDTO;
import com.irbeh.app.entities.Interaction;



public interface InteractionService {

	
	InteractionResponseDTO getInteraction(String id);
	List<InteractionResponseDTO> getInteractions();
	InteractionResponseDTO save(InteractionRequestDTO interactionRequestDTO);
	InteractionResponseDTO update(InteractionRequestDTO interactionRequestDTO);
	void deleteInteraction(String id);
	InteractionResponseDTO findInteractionByPublicationId(String idPublication);

	
}
