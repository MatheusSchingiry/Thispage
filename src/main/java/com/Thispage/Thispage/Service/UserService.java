package com.Thispage.Thispage.Service;

import com.Thispage.Thispage.DTO.UserDTO;
import com.Thispage.Thispage.Domain.User;
import com.Thispage.Thispage.Mapper.UserMapper;
import com.Thispage.Thispage.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDTO createUser(UserDTO user) {
        User userEntity = userMapper.toEntity(user);
        userRepository.save(userEntity);
        return userMapper.toDTO(userEntity);
    }

    public UserDTO getUserById(UUID id) {
        return userMapper.toDTO(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")));
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
