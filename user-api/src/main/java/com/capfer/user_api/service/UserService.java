package com.capfer.user_api.service;

import com.capfer.user_api.dto.UserDTO;
import com.capfer.user_api.mapper.UserMapper;
import com.capfer.user_api.model.User;
import com.capfer.user_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO findById(long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.map(UserMapper::toDTO).orElse(null);
    }

    public UserDTO save(UserDTO userDTO) {
        User user = userRepository.save(UserMapper.toUser(userDTO));
        return UserMapper.toDTO(user);
    }

    public UserDTO delete(long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        optionalUser.ifPresent(userRepository::delete);
        return null;
    }

    public UserDTO findByCpf(String cpf) {
        Optional<User> optionalUser = userRepository.findByCpf(cpf);
        return optionalUser.map(UserMapper::toDTO)
                .orElse(null);
    }

    public List<UserDTO> queryByName(String name) {
        List<User> users = userRepository.queryByNameLike(name);
        return users.stream()
                .map(UserMapper::toDTO)
                .toList();
    }
}
