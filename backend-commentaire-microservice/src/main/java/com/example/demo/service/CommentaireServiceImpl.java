package com.example.demo.service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.CommentaireRequestDTO;
import com.example.demo.DTO.CommentaireResponseDTO;
import com.example.demo.mapper.CommentaireMapper;
import com.example.demo.model.Commentaire;
import com.example.demo.repository.CommentaireRepository;

@Service
public class CommentaireServiceImpl implements CommentaireService {
	
	@Autowired
	private CommentaireRepository commentaireRepository;
	private CommentaireMapper commentaireMapper;
	
	public CommentaireServiceImpl(CommentaireRepository commentaireRepository, CommentaireMapper commentaireMapper) {
		super();
		this.commentaireRepository = commentaireRepository;
		this.commentaireMapper = commentaireMapper;
	}
	@Override
	public List<CommentaireResponseDTO> getCommentaire() {
		List<Commentaire> commentaires=commentaireRepository.findAll();
		return commentaires.stream().map((commentaire)-> commentaireMapper.commentaireToCommentaireDTO(commentaire)).collect(Collectors.toList());
	}
	@Override
	public CommentaireResponseDTO getCommentaire(String id) {
		Commentaire commentaire=commentaireRepository.findById(id).get();
		return commentaireMapper.commentaireToCommentaireDTO(commentaire);
	}
	@Override
	public CommentaireResponseDTO save(CommentaireRequestDTO commentaireRequestDTO) {
		Commentaire commentaire = commentaireMapper.commentaireRequestDTOToCommentaire(commentaireRequestDTO);
		Commentaire saveCommentaire= commentaireRepository.save(commentaire);
		return commentaireMapper.commentaireToCommentaireDTO(saveCommentaire);

	}
	@Override
	public void deleteCommentaire(String id) {
		commentaireRepository.deleteById(id);
		
	}


	@Override
	public CommentaireResponseDTO update(CommentaireRequestDTO commentaireRequestDTO) {
		// TODO Auto-generated method stub
		Commentaire commentaire=commentaireMapper.commentaireRequestDTOToCommentaire(commentaireRequestDTO);
		Commentaire savedCommentaire= commentaireRepository.save(commentaire);
		return commentaireMapper.commentaireToCommentaireDTO(savedCommentaire);
	}
	
	@Override
	public List <CommentaireResponseDTO> getCommentaireByPostId(String id) {
		// TODO Auto-generated method stub
		List<Commentaire> commentaires=commentaireRepository.findByIdPost(id);
		return commentaires.stream().map((commentaire)-> commentaireMapper.commentaireToCommentaireDTO(commentaire)).collect(Collectors.toList());
	}
}
