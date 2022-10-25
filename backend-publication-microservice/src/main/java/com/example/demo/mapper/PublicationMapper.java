package com.example.demo.mapper;

import com.example.demo.model.Publication;
import com.example.demo.model.PublicationRequestDTO;
import com.example.demo.model.PublicationResponseDTO;

public interface PublicationMapper {
	PublicationResponseDTO publicationToPublicationDTO(Publication publication);
	Publication publicationRequestDTOToPublication (PublicationRequestDTO publicationRequestDTO);
}
