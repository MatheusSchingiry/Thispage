package com.Thispage.Thispage.DTO;

import com.Thispage.Thispage.Domain.User;

import java.util.UUID;

public record CredentialsDTO(UUID id,
                             User user,
                             String email,
                             String password) {
}
