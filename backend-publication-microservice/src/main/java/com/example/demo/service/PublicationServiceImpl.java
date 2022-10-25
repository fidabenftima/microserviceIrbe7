package com.example.demo.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.PublicationMapper;
import com.example.demo.model.Publication;
import com.example.demo.model.PublicationRequestDTO;
import com.example.demo.model.PublicationResponseDTO;
import com.example.demo.repository.PublicationRepository;

@Service
public class PublicationServiceImpl  implements PublicationService{
	private PublicationRepository publicationRepository;
	private PublicationMapper publicationMapper;


    public PublicationServiceImpl (PublicationRepository publicationRepository, PublicationMapper PublicationMapper, PublicationMapper publicationMapper) {
	this.publicationMapper= publicationMapper;
	this.publicationRepository= publicationRepository;
	}
	@Override
	public PublicationResponseDTO getPublication(String id) {
		Publication publication=publicationRepository.findById(id).get();
		return publicationMapper.publicationToPublicationDTO(publication);
	}
	@Override
	public List<PublicationResponseDTO> getPublication() {
		List<Publication> publications=publicationRepository.findAll();
		return publications.stream().map((publication)-> publicationMapper.publicationToPublicationDTO(publication)).collect(Collectors.toList());
	}

	@Override
	public PublicationResponseDTO save(PublicationRequestDTO publicationRequestDTO) {
		Publication publication = publicationMapper.publicationRequestDTOToPublication(publicationRequestDTO);
		Publication savePublication= publicationRepository.save(publication);
		return publicationMapper.publicationToPublicationDTO(savePublication);
	}
	@Override
	public PublicationResponseDTO update(PublicationRequestDTO publicationRequestDTO) {
		Publication publication = publicationMapper.publicationRequestDTOToPublication(publicationRequestDTO);
		Publication savePublication= publicationRepository.save(publication);
		return publicationMapper.publicationToPublicationDTO(savePublication);
	}


	@Override
	public void deletePublication(String id) {
		publicationRepository.deleteById(id);
	}
	@Override
	public List<PublicationResponseDTO> findByIdUtilisateur(String idUtilisateur) {
		return publicationRepository.findByIdUtilisateur(idUtilisateur).stream().map((publication)-> publicationMapper.publicationToPublicationDTO(publication)).collect(Collectors.toList());
	}
	@Override
	public List<String> findByDate(){
		List<String> dates = new ArrayList<String>();
		List<Publication> publications=publicationRepository.findAll();
		for(int i=0;i<publications.size();i++) {
			dates.add(publications.get(i).getDate().substring(0, 10));
		}
		return dates;
	}
	
	@Override
	public List<String> findLastNdaysPublications(int n){
		List<Publication> publications=publicationRepository.findAll();
		List<String> dates = new ArrayList<String>();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String[] days = new String[n];
        days[0] = dateFormat.format(date);
        for(int i = 1; i < n; i++){
            cal.add(Calendar.DAY_OF_MONTH, -1);
            date = cal.getTime();
            days[i] = dateFormat.format(date);
        }
		for(int i=0;i<publications.size();i++) {
			if(Arrays.asList(days).contains(publications.get(i).getDate().substring(0, 10))) {
				dates.add(publications.get(i).getDate().substring(0, 10));
			}
		}
		return dates;
	}
	
	@Override
	public List<PublicationResponseDTO> findByIdGroupe(String idGroupe){
		return publicationRepository.findByIdGroupe(idGroupe).stream().map((publication)-> publicationMapper.publicationToPublicationDTO(publication)).collect(Collectors.toList());


	}
	

}
	