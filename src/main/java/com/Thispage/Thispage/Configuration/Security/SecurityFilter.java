package com.Thispage.Thispage.Configuration.Security;

import com.Thispage.Thispage.Domain.Credentials;
import com.Thispage.Thispage.Repository.CredentialsRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final CredentialsRepository credentialsRepository;

    public SecurityFilter(TokenService tokenService, CredentialsRepository credentialsRepository) {
        this.tokenService = tokenService;
        this.credentialsRepository = credentialsRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoveryToken(request);
        var login = tokenService.validateToken(token);

        if(login == null) {
            Credentials credential = credentialsRepository.findByEmail(login).orElseThrow(() -> new RuntimeException("Invalid token"));
            var authority = Collections.singletonList(new SimpleGrantedAuthority("Role_User"));
            var authentication = new UsernamePasswordAuthenticationToken(credential, null, authority);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    private String recoveryToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ", "");
        }
        return null;
    }
}
