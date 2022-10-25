package com.example.demo.mapper;

import com.example.demo.model.User;
import com.example.demo.model.UserRequestDTO;
import com.example.demo.model.UserResponseDTO;

public interface UserMapper {
	UserResponseDTO userToUserDTO(User user);
	User userRequestDTOToUser (UserRequestDTO userRequestDTO);

}
