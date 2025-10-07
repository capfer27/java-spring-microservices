package com.capfer.user_api.fixtures;

import com.capfer.user_api.dto.UserDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserFixtures {

    public static List<UserDTO> loadUsers() {
        List<UserDTO> users = new ArrayList<>();
        Date currentDate = new Date();
        UserDTO userDTO = new UserDTO(
                "Eduard",
                "123",
                "Street 123",
                "eduard@gmail.com",
                "1234-4567-987",
                currentDate
        );
        UserDTO userDTO2 = new UserDTO(
                "Peter",
                "456",
                "Street 456",
                "peter@gmail.com",
                "1234-4567-987",
                currentDate
        );
        UserDTO userDTO3 = new UserDTO(
                "Sue",
                "789",
                "Street 789",
                "sue@gmail.com",
                "1234-4567-987",
                currentDate
        );

        users.add(userDTO);
        users.add(userDTO2);
        users.add(userDTO3);

        return users;
    }
}
