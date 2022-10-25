package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.model.Publication;
import com.example.demo.model.PublicationRequestDTO;
import com.example.demo.model.PublicationResponseDTO;

@Component
public class PublicationMapperImpl implements PublicationMapper{

	@Override
	public PublicationResponseDTO publicationToPublicationDTO(Publication publication) {
		 if (publication == null ) {
	            return null;
	        }

		 PublicationResponseDTO publicationResponseDTO = new PublicationResponseDTO();
		 publicationResponseDTO.setId( publication.getId() );
		 publicationResponseDTO.setDate( publication.getDate() );
		 publicationResponseDTO.setIdUtilisateur( publication.getIdUtilisateur() );
		 publicationResponseDTO.setIdGroupe( publication.getIdGroupe() );
		 publicationResponseDTO.setImage( publication.getImage() );
		 publicationResponseDTO.setContenu( publication.getContenu() );	
		 publicationResponseDTO.setNbPartage( publication.getNbPartage() );
		 publicationResponseDTO.setActif(publication.getActif());


	        return publicationResponseDTO;
	}

	@Override
	public Publication publicationRequestDTOToPublication(PublicationRequestDTO publicationRequestDTO) {
		if (publicationRequestDTO == null ) {
            return null;
        }

		Publication publication = new Publication();

        publication.setId( publicationRequestDTO.getId() );
		publication.setDate( publicationRequestDTO.getDate() );
        publication.setIdUtilisateur( publicationRequestDTO.getIdUtilisateur() );
        publication.setIdGroupe(publicationRequestDTO.getIdGroupe());
        publication.setImage( publicationRequestDTO.getImage() );
        publication.setContenu( publicationRequestDTO.getContenu() );
        publication.setNbPartage( publicationRequestDTO.getNbPartage() );
        publication.setActif(publicationRequestDTO.getActif());

     
        return publication;
	}

}
