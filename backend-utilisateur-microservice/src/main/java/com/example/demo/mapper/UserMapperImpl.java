package com.example.demo.mapper;


import org.springframework.stereotype.Component;

import com.example.demo.model.User;
import com.example.demo.model.UserRequestDTO;
import com.example.demo.model.UserResponseDTO;
@Component
public class UserMapperImpl implements UserMapper{

	@Override
	public UserResponseDTO userToUserDTO(User user) {
		 if (user == null ) {
	            return null;
	        }

		 UserResponseDTO userResponseDTO = new UserResponseDTO();
		 userResponseDTO.setUserId( user.getUserId() );
		 userResponseDTO.setUserName( user.getUserName() );
		 userResponseDTO.setNbSignal( user.getNbSignal() );
		 userResponseDTO.setEmail( user.getEmail() );
		 userResponseDTO.setType( user.getType() );
		 userResponseDTO.setActif( user.isActif() );
		 userResponseDTO.setSuspendu( user.isSuspendu() );
		 userResponseDTO.setPayant( user.isPayant() );
		 userResponseDTO.setMotPasse( user.getMotPasse() );
		 userResponseDTO.setNumTelephone( user.getNumTelephone() );
		 userResponseDTO.setDescription( user.getDescription() );
		 userResponseDTO.setDateActivation( user.getDateActivation() );
		 userResponseDTO.setPoste(user.getPoste());
		 userResponseDTO.setPays( user.getPays() );
		 userResponseDTO.setEntreprise( user.getEntreprise() );
		 userResponseDTO.setNom( user.getNom() );
		 userResponseDTO.setPrenom( user.getPrenom() );
		 userResponseDTO.setSexe( user.getSexe() );
		 userResponseDTO.setDateDeNaissance( user.getDateDeNaissance() );
		 userResponseDTO.setUrlPhotoProfil( user.getUrlPhotoProfil() );
		 userResponseDTO.setUrlPhotoCouverture( user.getUrlPhotoCouverture() );
		 userResponseDTO.setGroupe( user.getGroupe() );
         
	        return userResponseDTO;
	}

	@Override
	public User userRequestDTOToUser(UserRequestDTO userRequestDTO) {
		if (userRequestDTO == null ) {
            return null;
        }

		User user = new User();

        user.setUserId( userRequestDTO.getUserId() );
        user.setNbSignal( userRequestDTO.getNbSignal() );
        user.setUserName(userRequestDTO.getUserName() );
        user.setEmail(userRequestDTO.getEmail() );
        user.setType(userRequestDTO.getType() );
        user.setActif(userRequestDTO.isActif() );
        user.setSuspendu(userRequestDTO.isSuspendu() );
        user.setPayant(userRequestDTO.isPayant() );
        user.setMotPasse(userRequestDTO.getMotPasse() );
        user.setPoste(userRequestDTO.getPoste());
        user.setPays(userRequestDTO.getPays() );
        user.setNumTelephone(userRequestDTO.getNumTelephone() );
        user.setDescription(userRequestDTO.getDescription() );
        user.setDateActivation(userRequestDTO.getDateActivation() );
        user.setEntreprise(userRequestDTO.getEntreprise() );
        user.setNom(userRequestDTO.getNom() );
        user.setPrenom(userRequestDTO.getPrenom() );
        user.setSexe(userRequestDTO.getSexe() );
        user.setDateDeNaissance(userRequestDTO.getDateDeNaissance() );
        user.setUrlPhotoProfil(userRequestDTO.getUrlPhotoProfil() );
        user.setUrlPhotoCouverture(userRequestDTO.getUrlPhotoCouverture() );
		user.setGroupe(userRequestDTO.getGroupe() );

        return user;
	}

}
