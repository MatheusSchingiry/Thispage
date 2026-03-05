package com.Thispage.Thispage.Service;

import com.Thispage.Thispage.Configuration.Security.TokenService;
import com.Thispage.Thispage.DTO.AccessDTO;
import com.Thispage.Thispage.DTO.CredentialsDTO;
import com.Thispage.Thispage.Domain.Credentials;
import com.Thispage.Thispage.Mapper.CredentialsMapper;
import com.Thispage.Thispage.Repository.CredentialsRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CredentialsService {

    private final CredentialsRepository credentialsRepository;
    private final CredentialsMapper credentialsMapper;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public CredentialsService(CredentialsRepository credentialsRepository, CredentialsMapper credentialsMapper, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.credentialsRepository = credentialsRepository;
        this.credentialsMapper = credentialsMapper;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    public CredentialsDTO createCredentials(CredentialsDTO credentials) {
        Optional<Credentials> credentialsDomain = credentialsRepository.findByEmail(credentials.email());
        if(credentialsDomain.isPresent()){
            throw new RuntimeException("Email already in use");
        }

        Credentials newCredentials = credentialsMapper.toEntity(credentials);
        newCredentials.setPassword(passwordEncoder.encode(credentials.password()));
        credentialsRepository.save(newCredentials);

        return credentialsMapper.toDTO(newCredentials);
    }

    public CredentialsDTO getCredentialsByEmail(String email) {
        return credentialsMapper.toDTO(credentialsRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Credentials not found")));
    }

    public AccessDTO login(CredentialsDTO credentials) {
        Credentials existingCredentials = credentialsRepository.findByEmail(credentials.email()).orElseThrow(() -> new RuntimeException("Credentials not found"));
        if (passwordEncoder.matches(credentials.password(), existingCredentials.getPassword())) {
            String token = tokenService.generateToken(existingCredentials);
            return new AccessDTO(token);
        } else {
            throw new RuntimeException("Invalid email or password");
        }
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
