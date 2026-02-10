package com.Thispage.Thispage.Repository;

import com.Thispage.Thispage.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
