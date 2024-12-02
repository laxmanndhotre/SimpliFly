package com.hexaware.simplifly.mapper;


import com.hexaware.simplifly.dto.UserDTO;
import com.hexaware.simplifly.entities.User;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setContactNumber(user.getContactNumber());
        userDTO.setRole(user.getRole().name());
        return userDTO;
    }

    public static User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setContactNumber(userDTO.getContactNumber());
        user.setRole(User.Role.valueOf(userDTO.getRole().toLowerCase()));
        return user;
    }
}
