package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.model.Suivi;
import com.example.demo.model.SuiviRequestDTO;
import com.example.demo.model.SuiviResponseDTO;

@Component
public class SuiviMapperImpl implements SuiviMapper {

	

	@Override
	public SuiviResponseDTO suiviToSuiviDTO(Suivi suivi) {
		 if (suivi == null ) {
	            return null;
	        }

		 SuiviResponseDTO suiviResponseDTO = new SuiviResponseDTO();
		 suiviResponseDTO.setId( suivi.getId() );
		 suiviResponseDTO.setIdUtilisateurConnecte( suivi.getIdUtilisateurConnecte() );
		 suiviResponseDTO.setIdAmiSuivi( suivi.getIdAmiSuivi() );

	        return suiviResponseDTO;
	}

	@Override
	public Suivi suiviRequestDTOToSuivi(SuiviRequestDTO suiviRequestDTO) {
		if (suiviRequestDTO == null ) {
            return null;
        }

		Suivi suivi = new Suivi();

		suivi.setId( suiviRequestDTO.getId() );
		suivi.setIdUtilisateurConnecte( suiviRequestDTO.getIdUtilisateurConnecte() );
        suivi.setIdAmiSuivi( suiviRequestDTO.getIdAmiSuivi() );

        return suivi;
	}


}
