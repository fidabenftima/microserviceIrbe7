package com.irbeh.app.mappers;


import com.irbeh.app.dto.GroupeRequestDTO;
import com.irbeh.app.dto.GroupeResponseDTO;
import com.irbeh.app.entities.Groupe;

public interface GroupeMapper {

	
	GroupeResponseDTO GroupeToGroupeDTO(Groupe groupe);
	Groupe GroupeRequestDTOToGroupe(GroupeRequestDTO groupeRequestDTO);
	
}
