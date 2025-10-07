package com.capfer.user_api.controller;

import com.capfer.user_api.dto.UserDTO;
import com.capfer.user_api.service.UserService;
import com.capfer.user_api.util.UserUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        List<UserDTO> userDTOS = userService.getAll();
        return userDTOS;
    }

    @GetMapping("/users/{id}")
    public UserDTO getUsersFilter(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/users")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @PostMapping("/users/{id}")
    public UserDTO editUser(@PathVariable("id") Long id, @RequestBody UserDTO userDTO) {
        UserDTO editUser = userService.editUser(id, userDTO);
        return editUser;
    }

    @GetMapping("/users/cpf/{cpf}")
    public UserDTO findByCpf(@PathVariable String cpf) {
        return userService.findByCpf(cpf);
    }

    @DeleteMapping("/users/{id}")
    public UserDTO deleteUser(@PathVariable Long id) {
        return userService.delete(id);
    }

    @GetMapping("/users/search")
    public List<UserDTO> searchUsers(@RequestParam(name = "name", required = true) String name) {
        return userService.queryByName(name);
    }
}
