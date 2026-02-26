package com.Thispage.Thispage.DTO;

import com.Thispage.Thispage.Domain.Credentials;
import com.Thispage.Thispage.Domain.Post;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record UserDTO(UUID id,
                      Credentials credentials,
                      String username,
                      List<Post> posts) {
}
