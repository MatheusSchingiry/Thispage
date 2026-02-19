package com.Thispage.Thispage.Service;

import com.Thispage.Thispage.DTO.CredentialsDTO;
import com.Thispage.Thispage.Domain.Credentials;
import com.Thispage.Thispage.Mapper.CredentialsMapper;
import com.Thispage.Thispage.Repository.CredentialsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CredentialsService {

    private final CredentialsRepository credentialsRepository;
    private final CredentialsMapper credentialsMapper;

    public CredentialsService(CredentialsRepository credentialsRepository, CredentialsMapper credentialsMapper) {
        this.credentialsRepository = credentialsRepository;
        this.credentialsMapper = credentialsMapper;
    }

    public CredentialsDTO createCredentials(CredentialsDTO credentials) {
        Credentials newCredentials = credentialsMapper.toEntity(credentials);
        credentialsRepository.save(newCredentials);
        return credentialsMapper.toDTO(newCredentials);
    }

    public CredentialsDTO getCredentialsById(UUID id) {
        return credentialsMapper.toDTO(credentialsRepository.findById(id).orElseThrow(() -> new RuntimeException("Credentials not found")));
    }

    public List<CredentialsDTO> getAllCredentials() {
        return credentialsRepository
                .findAll()
                .stream()
                .map(credentialsMapper::toDTO)
                .toList();
    }

    public CredentialsDTO updateCredentials(UUID id, CredentialsDTO updatedCredentials) {
        Credentials existingCredentials = credentialsRepository.findById(id).orElseThrow(() -> new RuntimeException("Credentials not found"));
        existingCredentials.setEmail(updatedCredentials.email());
        existingCredentials.setPassword(updatedCredentials.password());
        return credentialsMapper.toDTO(credentialsRepository.save(existingCredentials));

    }

    public void deleteCredentials(UUID id) {
        credentialsRepository.deleteById(id);
    }
}
