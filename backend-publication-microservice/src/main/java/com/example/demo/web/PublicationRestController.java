package com.example.demo.web;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PublicationRequestDTO;
import com.example.demo.model.PublicationResponseDTO;
import com.example.demo.service.PublicationService;

@RestController
@RequestMapping(path="/api")
@CrossOrigin("*")

public class PublicationRestController {
	@Autowired
	 private PublicationService publicationService;
	@GetMapping(path="/publications")
	  public List<PublicationResponseDTO> publications(){
		  return publicationService.getPublication();
	  }
	  @GetMapping(path="/publications/{id}")
	  public PublicationResponseDTO publicationById(@PathVariable String id){
		  
		  return publicationService.getPublication(id);
	  }
	  @PostMapping(path="/publications")
	  public PublicationResponseDTO save(@RequestBody PublicationRequestDTO publicationRequestDTO) {
		  String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
		  String timeStamp2 = new SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
		  String tsFinal = timeStamp + "T" + timeStamp2 + "Z";
		  
		  publicationRequestDTO.setDate(tsFinal);
		  return publicationService.save(publicationRequestDTO);
	  }
	  @PutMapping(path="/publications/{id}")
	  public PublicationResponseDTO update(@RequestBody PublicationRequestDTO publicationRequestDTO,@PathVariable String id) {
		  publicationRequestDTO.setId(id);
		  return publicationService.save(publicationRequestDTO);}
	  @DeleteMapping(path="/publications/{id}")
	  public void delete(@PathVariable String id) {
		  publicationService.deletePublication(id);}
	  @GetMapping(path="/publications/idUtilisateur/{idUtilisateur}")
	  public List<PublicationResponseDTO> publicationsByIdUtilisateur(@PathVariable String idUtilisateur){
		  return publicationService.findByIdUtilisateur(idUtilisateur);
	  }
	  
	  @GetMapping(path="/publications/idGroupe/{idGroupe}")
	  public List<PublicationResponseDTO> publicationsByGroupe(@PathVariable String idGroupe){
		  return publicationService.findByIdGroupe(idGroupe);
	  }
	  
	  @GetMapping(path="/publications/dates")
	  public List<String> publicationsByDate(){
		  return publicationService.findByDate();
	  }
	  
	  @GetMapping(path="/publications/lastNdays/{n}")
	  public List<String> lastNdaysPublications(@PathVariable int n) {
		  return publicationService.findLastNdaysPublications(n);
	  }
	  
}


