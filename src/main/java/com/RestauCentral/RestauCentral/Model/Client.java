package com.RestauCentral.RestauCentral.Model;

import com.RestauCentral.RestauCentral.Model.Enum.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Client implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;       // Identifiant unique du client
    private String username;          // Nom du client
    private String password;
    private String email;
    private String adresse;      // Adresse du client
    private String contact;      // Contact du client (numéro de téléphone ou email)
    private int pointsFidelite;

    @Enumerated(EnumType.STRING)
    private Role role;


    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Commande> commandes;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getAuthority()));
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
