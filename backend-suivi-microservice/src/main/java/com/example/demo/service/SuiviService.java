package com.example.demo.service;

import java.util.List;

import com.example.demo.model.SuiviRequestDTO;
import com.example.demo.model.SuiviResponseDTO;

public interface SuiviService {
	SuiviResponseDTO getSuivi(String id);
	 List<SuiviResponseDTO> getSuivi();
	 SuiviResponseDTO save(SuiviRequestDTO suiviRequestDTO);
	 void deleteSuivi( String id);
	 List<SuiviResponseDTO> findByIdUtilisateurConnecte(String idUtilisateurConnecte);
	 List<SuiviResponseDTO> findByIdAmiSuivi(String idAmiSuivi);
	 List<SuiviResponseDTO> findByIdAmiSuiviAndIdUtilisateurConnecte (String idAmiSuivi, String idUtilisateurConnecte);
}
