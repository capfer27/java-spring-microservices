package com.capfer.user_api.mapper;

import com.capfer.user_api.dto.UserDTO;
import com.capfer.user_api.model.User;

import java.util.Date;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        return new UserDTO(
            user.getName(),
            user.getCpf(),
            user.getAddress(),
            user.getEmail(),
            user.getPhone(),
            user.getCreatedAt()
        );
    }

    public static User toUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.name());
        user.setCpf(userDTO.cpf());
        user.setEmail(userDTO.email());
        user.setAddress(userDTO.address());
        user.setPhone(userDTO.phone());
        user.setCreatedAt(userDTO.createdAt());
        return user;
    }
}
