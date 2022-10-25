package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.SuiviMapper;
import com.example.demo.model.Suivi;
import com.example.demo.model.SuiviRequestDTO;
import com.example.demo.model.SuiviResponseDTO;
import com.example.demo.repository.SuiviRepository;

@Service
public class SuiviServiceImpl implements SuiviService {
	private SuiviRepository suiviRepository;
	private SuiviMapper suiviMapper;
	
    public SuiviServiceImpl (SuiviRepository suiviRepository, SuiviMapper suiviMapper) {
	this.suiviMapper= suiviMapper;
	this.suiviRepository= suiviRepository;
	}

	@Override
	public SuiviResponseDTO getSuivi(String id) {
		Suivi suivi=suiviRepository.findById(id).get();
		return suiviMapper.suiviToSuiviDTO(suivi);
	}

	@Override
	public List<SuiviResponseDTO> getSuivi() {
		List<Suivi> suivis=suiviRepository.findAll();
		return suivis.stream().map((suivi)-> suiviMapper.suiviToSuiviDTO(suivi)).collect(Collectors.toList());
	}

	@Override
	public SuiviResponseDTO save(SuiviRequestDTO suiviRequestDTO) {
		Suivi suivi = suiviMapper.suiviRequestDTOToSuivi(suiviRequestDTO);
		Suivi saveSuivi= suiviRepository.save(suivi);
		return suiviMapper.suiviToSuiviDTO(saveSuivi);
	}

	@Override
	public void deleteSuivi(String id) {
		suiviRepository.deleteById(id);
	}

	@Override
	public List<SuiviResponseDTO> findByIdUtilisateurConnecte(String idUtilisateurConnecte) {
		return suiviRepository.findByIdUtilisateurConnecte(idUtilisateurConnecte).stream().map((suivi)-> suiviMapper.suiviToSuiviDTO(suivi)).collect(Collectors.toList());
	}

	@Override
	public List<SuiviResponseDTO> findByIdAmiSuivi(String idAmiSuivi) {
		return suiviRepository.findByIdAmiSuivi(idAmiSuivi).stream().map((suivi)-> suiviMapper.suiviToSuiviDTO(suivi)).collect(Collectors.toList());
	}

	@Override
	public List<SuiviResponseDTO> findByIdAmiSuiviAndIdUtilisateurConnecte(String idAmiSuivi,
			String idUtilisateurConnecte) {
		return suiviRepository.findByIdAmiSuiviAndIdUtilisateurConnecte(idAmiSuivi, idUtilisateurConnecte).stream().map((suivi)-> suiviMapper.suiviToSuiviDTO(suivi)).collect(Collectors.toList());

	}

}
