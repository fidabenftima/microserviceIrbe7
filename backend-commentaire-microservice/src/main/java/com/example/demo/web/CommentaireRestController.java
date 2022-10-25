package com.example.demo.web;

import java.util.List;
import java.text.SimpleDateFormat;

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

import com.example.demo.DTO.CommentaireRequestDTO;
import com.example.demo.DTO.CommentaireResponseDTO;
import com.example.demo.service.CommentaireService;



@RestController
@RequestMapping(path="/api")
@CrossOrigin("*")
public class CommentaireRestController {
	@Autowired
	 private CommentaireService commentaireService;
	@GetMapping(path="/commentaires")
	  public List<CommentaireResponseDTO> commentaires(){
		  return commentaireService.getCommentaire();
	  }
	  @GetMapping(path="/commentaires/{id}")
	  public CommentaireResponseDTO commentaireById(@PathVariable String id){
		  
		  return commentaireService.getCommentaire(id);
	  }
	  @PostMapping(path="/commentaires")
	  public CommentaireResponseDTO save(@RequestBody CommentaireRequestDTO commentaireRequestDTO) {
                  String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
		  String timeStamp2 = new SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
		  String tsFinal = timeStamp + "T" + timeStamp2 + "Z";
		  
		  commentaireRequestDTO.setDate(tsFinal);
		  return commentaireService.save(commentaireRequestDTO);
	  }

	  @PutMapping(path="/commentaires/{id}")
	  public CommentaireResponseDTO update(@RequestBody CommentaireRequestDTO commentaireRequestDTO,@PathVariable String id) {
		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
		  String timeStamp2 = new SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
		  String tsFinal = timeStamp + "T" + timeStamp2 + "Z";
		  
		 commentaireRequestDTO.setDate(tsFinal);
		 commentaireRequestDTO.setId(id);
	  
	    return commentaireService.save(commentaireRequestDTO);
	    
	 }

	  @DeleteMapping(path="/commentaires/{id}")
	  public void delete(@PathVariable String id) {
		  commentaireService.deleteCommentaire(id);}
	}

	

