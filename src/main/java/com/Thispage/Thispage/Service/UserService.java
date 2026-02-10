package com.Thispage.Thispage.Service;

import com.Thispage.Thispage.Domain.User;
import com.Thispage.Thispage.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
