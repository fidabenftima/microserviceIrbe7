package com.example.demo.service;

import java.util.List;

import com.example.demo.model.UserRequestDTO;
import com.example.demo.model.UserResponseDTO;


public interface UserService {
	UserResponseDTO getUser(String id);
	 List<UserResponseDTO> getUser();
	 UserResponseDTO save(UserRequestDTO userRequestDTO);
	 UserResponseDTO update(UserRequestDTO userRequestDTO);
	 void deleteUser( String id);
	 List<UserResponseDTO> findByUserName(String userName);
	 List<UserResponseDTO> findByEmail(String email);
	 List<UserResponseDTO> findBySexe(String sexe);
	 int findUsersSupByAge (int age);
	 int findUsersInfByAge (int age);
	 List<String> findUsersByDateInscription();
	 int findActivatedUsers();
	 List<String> findLastNdaysUsers(int n);
	 List <String> findByMonth(String month); 
	 List<UserResponseDTO> findByGroupe(String groupe);

}
