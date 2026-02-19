package com.Thispage.Thispage.DTO;

import com.Thispage.Thispage.Domain.User;

import java.util.UUID;

public record PostDTO(UUID id,
                      String title,
                      String content,
                      User creator) {
}
