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

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.model.UserRequestDTO;
import com.example.demo.model.UserResponseDTO;
import com.example.demo.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	private UserRepository userRepository;
	private UserMapper userMapper;
	
    public UserServiceImpl (UserRepository userRepository, UserMapper userMapper) {
	this.userMapper= userMapper;
	this.userRepository= userRepository;
	}

	@Override
	public UserResponseDTO getUser(String id) {
		User user=userRepository.findById(id).get();
		return userMapper.userToUserDTO(user);
	}

	@Override
	public List<UserResponseDTO> getUser() {
		List<User> users=userRepository.findAll();
		return users.stream().map((user)-> userMapper.userToUserDTO(user)).collect(Collectors.toList());
	}

	@Override
	public UserResponseDTO save(UserRequestDTO userRequestDTO) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
		User user = userMapper.userRequestDTOToUser(userRequestDTO);
		user.setDateInscription(dateFormat.format(date).toString());
		User saveUser= userRepository.save(user);
		return userMapper.userToUserDTO(saveUser);
	}

	@Override
	public UserResponseDTO update(UserRequestDTO userRequestDTO) {
		User user=userMapper.userRequestDTOToUser(userRequestDTO);
		User saveUser= userRepository.save(user);
		return userMapper.userToUserDTO(saveUser);
	}

	@Override
	public void deleteUser(String id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public List<UserResponseDTO> findByUserName(String userName) {
		return userRepository.findByUserName(userName).stream().map((user)-> userMapper.userToUserDTO(user)).collect(Collectors.toList());
	}

	@Override
	public List<UserResponseDTO> findByEmail(String email) {
		return userRepository.findByEmail(email).stream().map((user)-> userMapper.userToUserDTO(user)).collect(Collectors.toList());
	}
	
	@Override
	public List<UserResponseDTO> findBySexe(String sexe) {
		return userRepository.findBySexe(sexe).stream().map((user)-> userMapper.userToUserDTO(user)).collect(Collectors.toList());
	}
	
	@Override
	public int findUsersSupByAge(int age) {
		Calendar curr = Calendar.getInstance();
		int count = 0;
		List<User> users=userRepository.findAll();
		for(int i=0; i<users.size();i++) {
			if(users.get(i).getDateDeNaissance() != null) {
				if (curr.get(Calendar.YEAR)- Integer.parseInt(users.get(i).getDateDeNaissance().substring(0,4))>=age) {
					count++;
				}
				
			}
		}
		return count;
		
	}
	
	@Override
	public int findUsersInfByAge(int age) {
		Calendar curr = Calendar.getInstance();
		int count = 0;
		List<User> users=userRepository.findAll();
		for(int i=0; i<users.size();i++) {
			if(users.get(i).getDateDeNaissance() != null) {
				if (curr.get(Calendar.YEAR)- Integer.parseInt(users.get(i).getDateDeNaissance().substring(0,4))<age) {
					count++;
				}
				
			}
		}
		return count;
		
	}
	
	
	@Override
	
	public List<String> findUsersByDateInscription(){
		List<User> users = userRepository.findAll();
		List<String> dates = new ArrayList<String>();
		for(int i=0;i<users.size();i++) {
			dates.add(users.get(i).getDateInscription());
		}
		return dates;
	}
	
	@Override
	public int findActivatedUsers() {
		List<User> users = userRepository.findAll();
		int count =0;
		for(int i=0;i<users.size();i++) {
			if(users.get(i).isActif()) {
				count++;
			}
		}
		return count;
	}
	
	@Override
	public List<String> findLastNdaysUsers(int n){
		List<User> users = userRepository.findAll();
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
		for(int i=0;i<users.size();i++) {
			if(Arrays.asList(days).contains(users.get(i).getDateInscription())) {
				dates.add(users.get(i).getDateInscription());
			}
		}
		return dates;
	}

	@Override
	public List<String> findByMonth(String month){
		List <User> users = userRepository.findAll();
		List<String> dates = new ArrayList<String>();
		for(int i=0;i<users.size();i++) {
			

			if(month.equals(users.get(i).getDateInscription().substring(5, 7))) {
				dates.add(users.get(i).getDateInscription());
			}
		}
	
		return dates;
		}
	@Override
	public List<UserResponseDTO> findByGroupe(String groupe) {
		return userRepository.findByGroupe(groupe).stream().map((user)-> userMapper.userToUserDTO(user)).collect(Collectors.toList());
	}
	
}


