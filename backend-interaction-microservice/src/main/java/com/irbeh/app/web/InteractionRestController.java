package com.irbeh.app.web;

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
import com.irbeh.app.dto.InteractionRequestDTO;
import com.irbeh.app.dto.InteractionResponseDTO;
import com.irbeh.app.services.InteractionService;



@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping(path="api")
public class InteractionRestController {

	
private InteractionService interactionService;
	
	public InteractionRestController(InteractionService interactionService) {
		this.interactionService = interactionService;
	}
	
	@GetMapping(path ="/interactions")
	public List<InteractionResponseDTO> interactions(){
		return interactionService.getInteractions();
	}
	
	@GetMapping(path ="/interactions/{id}")
	public InteractionResponseDTO interactionById(@PathVariable String id) {
		return interactionService.getInteraction(id);
	}
	
	@PostMapping(path="/interactions")
	  public InteractionResponseDTO save(@RequestBody InteractionRequestDTO interactionRequestDTO) {
	    return interactionService.save(interactionRequestDTO);
	  }
	
	@PutMapping(path="/interactions/{id}")
	  public InteractionResponseDTO update(@RequestBody InteractionRequestDTO interactionRequestDTO,@PathVariable String id) {
		  interactionRequestDTO.setId(id);
	  
		  return interactionService.save(interactionRequestDTO);}
	
	  @DeleteMapping(path="/interactions/{id}")
	  public void delete(@PathVariable String id) {
		  interactionService.deleteInteraction(id);
		  }
	  @GetMapping(path ="/interactions/publication/{id}")
		public InteractionResponseDTO interactionByPublicationId(@PathVariable String id) {
			return interactionService.findInteractionByPublicationId(id);
		}
	
}
