package com.Thispage.Thispage.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credentials_id", referencedColumnName = "id")
    private Credentials credentials;

    @Column(nullable = false, length = 255, unique = true)
    private String username;

    @JsonIgnore
    @OneToMany(mappedBy = "creator", fetch = FetchType.LAZY)
    private List<Post> posts;
}
