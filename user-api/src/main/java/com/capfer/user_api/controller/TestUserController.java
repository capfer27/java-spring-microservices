package com.capfer.user_api.controller;

import com.capfer.user_api.dto.UserDTO;
import com.capfer.user_api.futures.UserFixtures;
import com.capfer.user_api.util.UserUtil;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestUserController {

    private static List<UserDTO> users = new ArrayList<>();

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return users;
    }

    @GetMapping("users/{cpf}")
    public UserDTO getUsersFilter(@PathVariable String cpf) {
        return users.stream()
                .filter(userDTO -> userDTO.cpf().equals(cpf))
                .findFirst()
//                .orElseThrow( () -> new IllegalArgumentException("User with cpf " + cpf + " not found"));
                .orElse(null);
    }

    @PostMapping("/newUser")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        UserDTO newUser = UserUtil.createUser(userDTO);
        users.add(newUser);
        return newUser;
    }

    @DeleteMapping("/user/{cpf}")
    public boolean deleteUser(@PathVariable String cpf) {
        return users.removeIf(userDTO -> userDTO.cpf().equals(cpf));
    }

    @PostConstruct
    public void initiateList() {
        users = UserFixtures.loadUsers();
    }
}
