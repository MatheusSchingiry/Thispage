package com.Thispage.Thispage.Service;

import com.Thispage.Thispage.Domain.Credentials;
import com.Thispage.Thispage.Repository.CredentialsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CredentialsService {

    private final CredentialsRepository credentialsRepository;

    public CredentialsService(CredentialsRepository credentialsRepository) {
        this.credentialsRepository = credentialsRepository;
    }

    public Credentials createCredentials(Credentials credentials) {
        return credentialsRepository.save(credentials);
    }

    public Credentials getCredentialsById(UUID id) {
        return credentialsRepository.findById(id).orElse(null);
    }

    public List<Credentials> getAllCredentials() {
        return credentialsRepository.findAll();
    }

    public Credentials updateCredentials(UUID id, Credentials updatedCredentials) {
        Credentials existingCredentials = credentialsRepository.findById(id).orElseThrow(() -> new RuntimeException("Credentials not found"));
        existingCredentials.setEmail(updatedCredentials.getEmail());
        existingCredentials.setPassword(updatedCredentials.getPassword());
        return credentialsRepository.save(existingCredentials);

    }

    public void deleteCredentials(UUID id) {
        credentialsRepository.deleteById(id);
    }
}
