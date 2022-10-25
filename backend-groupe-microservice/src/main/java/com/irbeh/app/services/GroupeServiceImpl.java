package com.irbeh.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.irbeh.app.Repository.GroupeRepository;
import com.irbeh.app.dto.GroupeRequestDTO;
import com.irbeh.app.dto.GroupeResponseDTO;
import com.irbeh.app.entities.Groupe;
import com.irbeh.app.mappers.GroupeMapper;

@Service
public class GroupeServiceImpl implements GroupeService {

	
	private GroupeRepository groupeRepository;
	private GroupeMapper groupeMapper;
	
	public GroupeServiceImpl(GroupeRepository groupeRepository, GroupeMapper groupeMapper) {
		this.groupeRepository = groupeRepository;
		this.groupeMapper = groupeMapper;
	}
	
	@Override
	public GroupeResponseDTO getGroupe(String id) {
		// TODO Auto-generated method stub
		Groupe groupe=groupeRepository.findById(id).get();
		return groupeMapper.GroupeToGroupeDTO(groupe);
	}

	@Override
	public List<GroupeResponseDTO> getGroupe() {
		// TODO Auto-generated method stub
		List<Groupe> groupes=groupeRepository.findAll();
		
		return groupes.stream().map((groupe)-> groupeMapper.GroupeToGroupeDTO(groupe)).collect(Collectors.toList());
	}

	@Override
	public GroupeResponseDTO save(GroupeRequestDTO groupeRequestDTO) {
		// TODO Auto-generated method stub
		Groupe groupe=groupeMapper.GroupeRequestDTOToGroupe(groupeRequestDTO);
		Groupe savedGroupe= groupeRepository.save(groupe);
		return groupeMapper.GroupeToGroupeDTO(savedGroupe);
	}
	@Override
	public GroupeResponseDTO update(GroupeRequestDTO groupeRequestDTO) {
		// TODO Auto-generated method stub
		Groupe groupe=groupeMapper.GroupeRequestDTOToGroupe(groupeRequestDTO);
		Groupe savedGroupe= groupeRepository.save(groupe);
		return groupeMapper.GroupeToGroupeDTO(savedGroupe);
	}

	@Override
	public void deleteGroupe(String id) {
		// TODO Auto-generated method stub
		groupeRepository.deleteById(id);
		}
	@Override
	public List <GroupeResponseDTO> getGroupeByUserId(String id) {
		// TODO Auto-generated method stub
		List<Groupe> groupes=groupeRepository.findByIdUser(id);
		return groupes.stream().map((groupe)-> groupeMapper.GroupeToGroupeDTO(groupe)).collect(Collectors.toList());
	}
	
	@Override
	public List <GroupeResponseDTO> getPublicationByGroupeId(String id) {
		// TODO Auto-generated method stub
		List<Groupe> groupes=groupeRepository.findByIdPost(id);
		return groupes.stream().map((groupe)-> groupeMapper.GroupeToGroupeDTO(groupe)).collect(Collectors.toList());
	}
}
