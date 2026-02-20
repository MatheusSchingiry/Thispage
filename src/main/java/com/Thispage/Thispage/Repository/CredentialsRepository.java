package com.Thispage.Thispage.Repository;

import com.Thispage.Thispage.Domain.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CredentialsRepository extends JpaRepository<Credentials, UUID> {
    Optional<Credentials> findByEmail(String email);
}
