package com.Thispage.Thispage.Mapper;

import com.Thispage.Thispage.DTO.UserDTO;
import com.Thispage.Thispage.Domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserDTO dto) {
        return new User(
            dto.id(),
            dto.credentials(),
            dto.username(),
            dto.posts()
        );
    }

    public UserDTO toDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }
}
