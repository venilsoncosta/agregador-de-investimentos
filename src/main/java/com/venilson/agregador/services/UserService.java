package com.venilson.agregador.services;

import com.venilson.agregador.entity.User;
import com.venilson.agregador.entity.UserDTO;
import com.venilson.agregador.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID createUser(UserDTO userDTO){
        var entity = new User(null,
                userDTO.username(),
                userDTO.email(),
                userDTO.password(),
                Instant.now(),
                null);

        var userSaved = userRepository.save(entity);

        return userSaved.getUserId();
    }

    public Optional<User> getUserById(String userId) {
        return userRepository.findById(UUID.fromString(userId));
    }
}
