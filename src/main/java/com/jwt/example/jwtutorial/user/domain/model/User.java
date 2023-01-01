package com.jwt.example.jwtutorial.user.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jwt.example.jwtutorial.authority.domain.model.Authority;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "jwtuser")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @JsonIgnore
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String username;
    private String password;
    private String nickname;
    private boolean activated;

    @ManyToMany
    @JoinTable(
            name = "user_authority2",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;

}
