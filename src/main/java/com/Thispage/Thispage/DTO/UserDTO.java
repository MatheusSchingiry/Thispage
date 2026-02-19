package com.Thispage.Thispage.DTO;

import com.Thispage.Thispage.Domain.Post;

import java.util.List;
import java.util.UUID;

public record UserDTO(UUID id,
                      String username,
                      List<Post> posts) {
}
