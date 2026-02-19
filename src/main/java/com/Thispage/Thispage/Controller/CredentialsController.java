package com.Thispage.Thispage.Controller;

import com.Thispage.Thispage.Domain.Credentials;
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

    public Credentials createCredentials(Credentials credentials) {
        return credentialsService.createCredentials(credentials);
    }

    public Credentials getCredentialsById(UUID id) {
        return credentialsService.getCredentialsById(id);
    }

    public List<Credentials> getAllCredentials() {
        return credentialsService.getAllCredentials();
    }

    public Credentials updateCredentials(UUID id, Credentials updatedCredentials) {
        return credentialsService.updateCredentials(id, updatedCredentials);
    }

    public void deleteCredentials(UUID id) {
        credentialsService.deleteCredentials(id);
    }
}
