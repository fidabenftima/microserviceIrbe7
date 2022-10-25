package com.irbeh.app.services;

import java.util.List;

import com.irbeh.app.dto.GroupeRequestDTO;
import com.irbeh.app.dto.GroupeResponseDTO;

public interface GroupeService {

	GroupeResponseDTO getGroupe(String id);
	List<GroupeResponseDTO> getGroupe();
	GroupeResponseDTO save(GroupeRequestDTO groupeRequestDTO);
	GroupeResponseDTO update(GroupeRequestDTO groupeRequestDTO);
	void deleteGroupe( String id);
	List <GroupeResponseDTO> getGroupeByUserId(String id);
	List <GroupeResponseDTO> getPublicationByGroupeId(String id);

}
