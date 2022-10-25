package com.example.demo.service;

import java.util.List;

import com.example.demo.model.PublicationRequestDTO;
import com.example.demo.model.PublicationResponseDTO;


public interface PublicationService {
	PublicationResponseDTO getPublication(String id);
	 List<PublicationResponseDTO> getPublication();
	 PublicationResponseDTO save(PublicationRequestDTO publicationRequestDTO);
	 void deletePublication( String id);
	 PublicationResponseDTO update(PublicationRequestDTO publicationRequestDTO);
	 List<PublicationResponseDTO> findByIdUtilisateur(String idUtilisateur);
	 List<String> findByDate();
	 List<String> findLastNdaysPublications(int n);
	 List<PublicationResponseDTO> findByIdGroupe(String idGroupe);

}
