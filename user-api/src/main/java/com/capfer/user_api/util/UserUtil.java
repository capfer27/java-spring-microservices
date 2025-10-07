package com.capfer.user_api.util;

import com.capfer.user_api.dto.UserDTO;

import java.time.LocalDateTime;

public final class UserUtil {

    public static UserDTO createUser(UserDTO userDTO) {
        return new UserDTO(
                userDTO.name(),
                userDTO.cpf(),
                userDTO.address(),
                userDTO.email(),
                userDTO.phone(),
                LocalDateTime.now(),
                userDTO.key()
        );
    }

    public static boolean isValidEmail(String userDTOEmail, String userEmail) {
        return !userDTOEmail.isBlank() && !userDTOEmail.equals(userEmail);
    }

    public static boolean isValidPhoneNumber(String userDTOPhone, String userPhone) {
        return !userDTOPhone.isBlank() && !userDTOPhone.equals(userPhone);
    }

    public static boolean isValidAddress(String userDTOAddress, String userAddress) {
        return !userDTOAddress.isBlank() && !userDTOAddress.equals(userAddress);
    }
}
