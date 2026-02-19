package com.Thispage.Thispage.Mapper;

import com.Thispage.Thispage.DTO.UserDTO;
import com.Thispage.Thispage.Domain.User;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserMapper {

    public User toEntity(UserDTO dto) {
        return new User(
            dto.id(),
            dto.username(),
            dto.posts()
        );
    }

    public UserDTO toDTO(User user) {
        return new UserDTO(
            user.getId(),
            user.getUsername(),
            user.getPosts()
        );
    }
}
