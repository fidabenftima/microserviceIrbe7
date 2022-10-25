package com.irbeh.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.irbeh.app.Repository.InteractionRepository;
import com.irbeh.app.dto.InteractionRequestDTO;
import com.irbeh.app.dto.InteractionResponseDTO;
import com.irbeh.app.entities.Interaction;
import com.irbeh.app.mappers.InteractionMapper;

@Service
public class InteractionServiceImpl implements InteractionService {

	private InteractionRepository interactionRepository;
	private InteractionMapper interactionMapper;
	
	public InteractionServiceImpl(InteractionRepository interactionRepository, InteractionMapper interactionMapper) {
		this.interactionRepository = interactionRepository;
		this.interactionMapper = interactionMapper;
	}
	
	@Override
	public InteractionResponseDTO getInteraction(String id) {
		// TODO Auto-generated method stub
		Interaction interaction=interactionRepository.findById(id).get();
		return interactionMapper.InteractionToInteractionDTO(interaction);
	}

	@Override
	public List<InteractionResponseDTO> getInteractions() {
		// TODO Auto-generated method stub
		List<Interaction> interactions=interactionRepository.findAll();
		
		return interactions.stream().map((interaction)-> interactionMapper.InteractionToInteractionDTO(interaction)).collect(Collectors.toList());
	}

	@Override
	public InteractionResponseDTO save(InteractionRequestDTO interactionRequestDTO) {
		// TODO Auto-generated method stub
		Interaction interaction=interactionMapper.InteractionRequestDTOToInteraction(interactionRequestDTO);
		Interaction savedInteraction= interactionRepository.save(interaction);
		return interactionMapper.InteractionToInteractionDTO(savedInteraction);
	}
	
	@Override
	public InteractionResponseDTO update(InteractionRequestDTO interactionRequestDTO) {
		Interaction interaction=interactionMapper.InteractionRequestDTOToInteraction(interactionRequestDTO);
		Interaction saveInteraction= interactionRepository.save(interaction);
		return interactionMapper.InteractionToInteractionDTO(saveInteraction);
	}

	@Override
	public void deleteInteraction(String id) {
		// TODO Auto-generated method stub
		interactionRepository.deleteById(id);
	}
	
	@Override
	public InteractionResponseDTO findInteractionByPublicationId(String idPublication) {
		Interaction interaction=interactionRepository.findByIdPublication(idPublication);
		return interactionMapper.InteractionToInteractionDTO(interaction);

		
	}
		
	
}
