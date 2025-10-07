package com.capfer.user_api.fixtures;

import com.capfer.user_api.dto.UserDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserFixtures {

    public static List<UserDTO> loadUsers() {
        List<UserDTO> users = new ArrayList<>();
        LocalDateTime currentDate = LocalDateTime.now();
        UserDTO userDTO = new UserDTO(
                "Eduard",
                "123",
                "Street 123",
                "eduard@gmail.com",
                "1234-4567-987",
                currentDate,
                UUID.randomUUID().toString()
        );
        UserDTO userDTO2 = new UserDTO(
                "Peter",
                "456",
                "Street 456",
                "peter@gmail.com",
                "1234-4567-987",
                currentDate,
                UUID.randomUUID().toString()
        );
        UserDTO userDTO3 = new UserDTO(
                "Sue",
                "789",
                "Street 789",
                "sue@gmail.com",
                "1234-4567-987",
                currentDate,
                UUID.randomUUID().toString()
        );

        users.add(userDTO);
        users.add(userDTO2);
        users.add(userDTO3);

        return users;
    }
}
