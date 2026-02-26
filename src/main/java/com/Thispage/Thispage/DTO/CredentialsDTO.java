package com.Thispage.Thispage.DTO;

import com.Thispage.Thispage.Domain.User;
import lombok.Builder;

import java.util.UUID;

@Builder
public record CredentialsDTO(UUID id,
                             User user,
                             String email,
                             String password) {
}
