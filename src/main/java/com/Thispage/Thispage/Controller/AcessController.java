package com.Thispage.Thispage.Controller;

import com.Thispage.Thispage.DTO.AcessDTO;
import com.Thispage.Thispage.DTO.CredentialsDTO;
import com.Thispage.Thispage.Service.CredentialsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AcessController {

    private final CredentialsService credentialsService;

    public AcessController(CredentialsService credentialsService) {
        this.credentialsService = credentialsService;
    }

    @PostMapping("/login")
    public AcessDTO login(@RequestBody CredentialsDTO credentials) {
        return credentialsService.login(credentials);

    }

    @PostMapping("/register")
     public CredentialsDTO register(@RequestBody CredentialsDTO credentials) {
        return credentialsService.createCredentials(credentials);
     }
}
