package com.Thispage.Thispage.Controller;

import com.Thispage.Thispage.DTO.CredentialsDTO;
import com.Thispage.Thispage.Service.CredentialsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/credentials")
public class CredentialsController {

    private final CredentialsService credentialsService;

    public CredentialsController(CredentialsService credentialsService) {
        this.credentialsService = credentialsService;
    }

    @PostMapping
    public CredentialsDTO getCredentialsByEmail(String email) {
        return credentialsService.getCredentialsByEmail(email);
    }

    @GetMapping
    public List<CredentialsDTO> getAllCredentials() {
        return credentialsService.getAllCredentials();
    }

    @PutMapping
    public CredentialsDTO updateCredentials(UUID id, CredentialsDTO updatedCredentials) {
        return credentialsService.updateCredentials(id, updatedCredentials);
    }

    @DeleteMapping
    public void deleteCredentials(UUID id) {
        credentialsService.deleteCredentials(id);
    }
}
