package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SuiviRequestDTO;
import com.example.demo.model.SuiviResponseDTO;
import com.example.demo.service.SuiviService;

@RestController
@RequestMapping(path="/api")
@CrossOrigin("*")
public class SuiviRestController {
	@Autowired
	 private SuiviService suiviService;
		
	  @GetMapping(path="/suivis")
	  public List<SuiviResponseDTO> suivis(){
		  return suiviService.getSuivi();
	  }
	  @GetMapping(path="/suivis/id/{id}")
	  public SuiviResponseDTO suiviById(@PathVariable String id){
		  
		  return suiviService.getSuivi(id);
	  }
	  @PostMapping(path="/suivis")
	  public SuiviResponseDTO save(@RequestBody SuiviRequestDTO suiviRequestDTO) {
		  return suiviService.save(suiviRequestDTO);
	  }
	  @DeleteMapping(path="/suivis/{id}")
	  public void delete(@PathVariable String id) {
		  suiviService.deleteSuivi(id);}
	  @GetMapping(path="/suivis/idUtilisateurConnecte/{idUtilisateurConnecte}")
	  public List<SuiviResponseDTO> suiviByIdUtilisateurConnecte(@PathVariable String idUtilisateurConnecte){
		  return suiviService.findByIdUtilisateurConnecte(idUtilisateurConnecte);
	  }
	  @GetMapping(path="/suivis/idAmiSuivi/{idAmiSuivi}")
	  public List<SuiviResponseDTO> suiviByIdAmiSuivi(@PathVariable String idAmiSuivi){
		  return suiviService.findByIdAmiSuivi(idAmiSuivi);
	  }
	  @GetMapping(path="/suivis/{idAmiSuivi}/{idUtilisateurConnecte}")
	  public List<SuiviResponseDTO> suiviByIdAmiSuiviAndIdUtilisateurConnecte(@PathVariable String idAmiSuivi,@PathVariable String idUtilisateurConnecte ){
		  return suiviService.findByIdAmiSuiviAndIdUtilisateurConnecte(idAmiSuivi, idUtilisateurConnecte);
	  }
	  
	}
