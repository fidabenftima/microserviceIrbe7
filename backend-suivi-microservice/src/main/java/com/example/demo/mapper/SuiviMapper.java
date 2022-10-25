package com.example.demo.mapper;

import com.example.demo.model.Suivi;
import com.example.demo.model.SuiviRequestDTO;
import com.example.demo.model.SuiviResponseDTO;

public interface SuiviMapper {
	SuiviResponseDTO suiviToSuiviDTO(Suivi suivi);
	Suivi suiviRequestDTOToSuivi (SuiviRequestDTO suiviRequestDTO);

}
