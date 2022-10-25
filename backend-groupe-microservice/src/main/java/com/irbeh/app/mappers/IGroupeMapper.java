package com.irbeh.app.mappers;

import org.springframework.stereotype.Component;

import com.irbeh.app.dto.GroupeRequestDTO;
import com.irbeh.app.dto.GroupeResponseDTO;
import com.irbeh.app.entities.Groupe;

@Component
public class IGroupeMapper implements GroupeMapper {

	@Override
	public GroupeResponseDTO GroupeToGroupeDTO(Groupe groupe) {
		// TODO Auto-generated method stub
		if (groupe == null ) {
            return null;
        }

		GroupeResponseDTO groupeResponseDTO = new GroupeResponseDTO();

		groupeResponseDTO.setId( groupe.getId() );
		groupeResponseDTO.setNom( groupe.getNom() );
		groupeResponseDTO.setImage( groupe.getImage() );
		groupeResponseDTO.setDescription( groupe.getDescription() );
		groupeResponseDTO.setIdUtilisateur( groupe.getIdUtilisateur() );
		groupeResponseDTO.setDate( groupe.getDate() );
		groupeResponseDTO.setEtat( groupe.getEtat() );
		groupeResponseDTO.setDomaine( groupe.getDomaine() );
		groupeResponseDTO.setPays( groupe.getPays() );
		groupeResponseDTO.setLangue( groupe.getLangue() );
		groupeResponseDTO.setMembre( groupe.getMembre() );
		groupeResponseDTO.setDemande( groupe.getDemande() );

     
        return groupeResponseDTO;
}

	@Override
	public Groupe GroupeRequestDTOToGroupe(GroupeRequestDTO groupeRequestDTO) {
		// TODO Auto-generated method stub
		if (groupeRequestDTO == null ) {
            return null;
        }

		Groupe groupe = new Groupe();

		groupe.setId( groupeRequestDTO.getId() );
		groupe.setNom( groupeRequestDTO.getNom() );
		groupe.setImage( groupeRequestDTO.getImage() );
		groupe.setDescription( groupeRequestDTO.getDescription() );
		groupe.setIdUtilisateur( groupeRequestDTO.getIdUtilisateur() );
        groupe.setDate( groupeRequestDTO.getDate() );
        groupe.setEtat( groupeRequestDTO.getEtat() );
        groupe.setDomaine( groupeRequestDTO.getDomaine() );
        groupe.setPays( groupeRequestDTO.getPays() );
        groupe.setLangue( groupeRequestDTO.getLangue() );
        groupe.setMembre( groupeRequestDTO.getMembre() );
        groupe.setDemande( groupeRequestDTO.getDemande() );



        return groupe;
  }

}
