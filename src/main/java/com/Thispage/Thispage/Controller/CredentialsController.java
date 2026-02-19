package com.Thispage.Thispage.Controller;

import com.Thispage.Thispage.DTO.CredentialsDTO;
import com.Thispage.Thispage.Service.CredentialsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/credentials")
public class CredentialsController {

    private final CredentialsService credentialsService;

    public CredentialsController(CredentialsService credentialsService) {
        this.credentialsService = credentialsService;
    }

    public CredentialsDTO createCredentials(CredentialsDTO credentials) {
        return credentialsService.createCredentials(credentials);
    }

    public CredentialsDTO getCredentialsById(UUID id) {
        return credentialsService.getCredentialsById(id);
    }

    public List<CredentialsDTO> getAllCredentials() {
        return credentialsService.getAllCredentials();
    }

    public CredentialsDTO updateCredentials(UUID id, CredentialsDTO updatedCredentials) {
        return credentialsService.updateCredentials(id, updatedCredentials);
    }

    public void deleteCredentials(UUID id) {
        credentialsService.deleteCredentials(id);
    }
}
