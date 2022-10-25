package com.irbeh.app.web;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irbeh.app.dto.GroupeRequestDTO;
import com.irbeh.app.dto.GroupeResponseDTO;
import com.irbeh.app.services.GroupeService;



@RestController
@RequestMapping(path="/api")
@CrossOrigin(origins = "*")
public class GroupeRestController {

private GroupeService groupeService;
	
	public GroupeRestController(GroupeService groupeService) {
		this.groupeService = groupeService;
	}
	@CrossOrigin("*")
	@GetMapping(path ="/groupes")
	public List<GroupeResponseDTO> groupes(){
		return groupeService.getGroupe();
	}
	
	@GetMapping(path ="/groupes/{id}")
	public GroupeResponseDTO groupeById(@PathVariable String id) {
		return groupeService.getGroupe(id);
	}
	
	@PostMapping(path="/groupes")
	  public GroupeResponseDTO save(@RequestBody GroupeRequestDTO groupeRequestDTO) {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
		  String timeStamp2 = new SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
		  String tsFinal = timeStamp + "T" + timeStamp2 + "Z";
		  
		    groupeRequestDTO.setDate(tsFinal);
	    return groupeService.save(groupeRequestDTO);
	  }
	 @PutMapping(path="/groupes/{id}")
	  public GroupeResponseDTO update(@RequestBody GroupeRequestDTO groupeRequestDTO,@PathVariable String id) {
		 groupeRequestDTO.setId(id);
	  
	    return groupeService.save(groupeRequestDTO);
	    
	 }
	  @DeleteMapping(path="/groupes/{id}")
	  public void delete(@PathVariable String id) {
		  groupeService.deleteGroupe(id);
		  }
	  
	  @GetMapping(path ="/groupes/post/({id}")
		public List<GroupeResponseDTO> groupeByPostId(@PathVariable String id) {
			return groupeService.getPublicationByGroupeId(id);
		}
	  
}
