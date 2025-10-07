package com.capfer.user_api.service;

import com.capfer.user_api.dto.UserDTO;
import com.capfer.user_api.exception.UserNotFoundException;
import com.capfer.user_api.mapper.UserMapper;
import com.capfer.user_api.model.User;
import com.capfer.user_api.repository.UserRepository;
import com.capfer.user_api.util.UserUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
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

    public Page<UserDTO> getAllPage(Pageable pageable) {
        Page<User> userPage = userRepository.findAll(pageable);
        return userPage.map(UserMapper::toDTO);
    }

    public UserDTO findById(long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.map(UserMapper::toDTO).orElse(null);
    }

    public UserDTO save(UserDTO userDTO) {
        User user = userRepository.save(UserMapper.toUser(userDTO));
        return UserMapper.toDTO(user);
    }

    public UserDTO saveUsingKey(UserDTO userDTO) {
        var key = UUID.randomUUID().toString();
        UserDTO copyDTO = getCopyDTO(userDTO, key);
        User user = userRepository.save(UserMapper.toUser(copyDTO));
        return UserMapper.toDTO(user);
    }

    private static UserDTO getCopyDTO(UserDTO userDTO, String key) {
        return new UserDTO(
                userDTO.name(),
                userDTO.cpf(),
                userDTO.address(),
                userDTO.email(),
                userDTO.phone(),
                LocalDateTime.now(),
                key
        );
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

    public UserDTO editUser(Long userId, UserDTO userDTO) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        if (UserUtil.isValidEmail(userDTO.email(), user.getEmail())) {
            user.setEmail(user.getEmail());
        }

        if (UserUtil.isValidPhoneNumber(userDTO.phone(), user.getPhone())) {
            user.setPhone(userDTO.phone());
        }

        if (UserUtil.isValidAddress(userDTO.address(), user.getAddress())) {
            user.setAddress(userDTO.address());
        }

        user = userRepository.save(user);
        return UserMapper.toDTO(user);
    }
}
