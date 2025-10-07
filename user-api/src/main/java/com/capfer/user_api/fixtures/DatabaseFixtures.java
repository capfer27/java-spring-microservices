package com.capfer.user_api.fixtures;

import com.capfer.user_api.dto.UserDTO;
import com.capfer.user_api.mapper.UserMapper;
import com.capfer.user_api.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseFixtures implements CommandLineRunner {

    private final UserRepository userRepository;

    public DatabaseFixtures(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        long count = userRepository.count();
        if (count == 0 ) { // Only insert if no data exists
            List<UserDTO> loadUsers = UserFixtures.loadUsers();
            loadUsers.forEach(userDTO -> {
                userRepository.save(UserMapper.toUser(userDTO));
            });
        }
    }
}
