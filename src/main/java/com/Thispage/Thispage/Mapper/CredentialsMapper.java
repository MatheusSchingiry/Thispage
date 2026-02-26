package com.Thispage.Thispage.Mapper;

import com.Thispage.Thispage.DTO.CredentialsDTO;
import com.Thispage.Thispage.Domain.Credentials;
import org.springframework.stereotype.Component;

@Component
public class CredentialsMapper {

    public Credentials toEntity(CredentialsDTO credentialsDTO) {
        return new Credentials(
                credentialsDTO.id(),
                credentialsDTO.user(),
                credentialsDTO.email(),
                credentialsDTO.password()
        );
    }

    public CredentialsDTO toDTO(Credentials credentials) {
        return  CredentialsDTO.builder()
                .id(credentials.getId())
                .email(credentials.getEmail())
                .build(
        );
    }
}
