package com.capfer.user_api.util;

import com.capfer.user_api.dto.UserDTO;

import java.util.Date;

public class UserUtil {

    public static UserDTO createUser(UserDTO userDTO) {
        return new UserDTO(
                userDTO.name(),
                userDTO.cpf(),
                userDTO.address(),
                userDTO.email(),
                userDTO.phone(),
                new Date()
        );
    }
}
