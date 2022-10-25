package com.example.demo.web;

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

import com.example.demo.model.UserRequestDTO;
import com.example.demo.model.UserResponseDTO;
import com.example.demo.service.UserService;



@RestController
@RequestMapping(path="/api")
@CrossOrigin(origins = "*",allowedHeaders = "*")

public class UserRestController {
	@Autowired
	 private UserService userService;
	@CrossOrigin("*")
	@GetMapping(path="/users")
	  public List<UserResponseDTO> users(){
		  return userService.getUser();
	  }
	  @GetMapping(path="/users/id/{id}")
	  public UserResponseDTO userById(@PathVariable String id){
		  
		  return userService.getUser(id);
	  }
	  @CrossOrigin(origins = "*",allowedHeaders = "*")
	  @PostMapping(path="/users",consumes = {"application/json;charset=UTF-8"}, produces={"application/json;charset=UTF-8"})
	  public UserResponseDTO save(@RequestBody UserRequestDTO userRequestDTO) {
		  return userService.save(userRequestDTO);
	  }
	  @PutMapping(path="/users/{id}")
	  public UserResponseDTO update(@RequestBody UserRequestDTO userRequestDTO,@PathVariable String id) {
		  userRequestDTO.setUserId(id);
	  
		  return userService.save(userRequestDTO);}
	  @DeleteMapping(path="/users/{id}")
	  public void delete(@PathVariable String id) {
		  userService.deleteUser(id);}
	  @GetMapping(path="/users/username/{userName}")
	  public List<UserResponseDTO> usersByUserName(@PathVariable String userName){
		  return userService.findByUserName(userName);
	  }
	  @GetMapping(path="/users/email/{email}")
	  public List<UserResponseDTO> usersByEmail(@PathVariable String email){
		  return userService.findByEmail(email);
	  }
	  
	  @GetMapping(path="/users/sexe/{sexe}")
	  public List<UserResponseDTO> usersBySexe(@PathVariable String sexe){
		  return userService.findBySexe(sexe);
	  }
	  @GetMapping(path="/users/naissance/{age}")
	  public int findAgesSup(@PathVariable int age){
		  return userService.findUsersSupByAge(age);
	  }
	  
	  @GetMapping(path="/users/naissanceInf/{age}")
	  public int findAgesInf(@PathVariable int age){
		  return userService.findUsersInfByAge(age);
	  }
	  
	  @GetMapping(path="/users/dates")
	  public List<String> findDates(){
		  return userService.findUsersByDateInscription();
	  }
	  
	  @GetMapping(path="/users/activated")
	  public int findActivated(){
		  return userService.findActivatedUsers();
	  }
	  
	  @GetMapping(path="/users/lastNdays/{n}")
		  public List<String> findLastNdaysUsers(@PathVariable int n){
		  return userService.findLastNdaysUsers(n);
	  }
	  
	  @GetMapping(path="/users/month/{month}")
	  public List<String> findDatesByMonth(@PathVariable String month){
		  return userService.findByMonth(month);
	  }
	  
	   @GetMapping(path="/users/groupe/{groupe}")
	  public List<UserResponseDTO> usersByGroupe(@PathVariable String groupe){
		  return userService.findByGroupe(groupe);
	  }
	  
	}




