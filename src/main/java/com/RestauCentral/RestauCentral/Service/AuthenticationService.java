package com.RestauCentral.RestauCentral.Service;

import com.RestauCentral.RestauCentral.Model.Admin;
import com.RestauCentral.RestauCentral.Model.Client;
import com.RestauCentral.RestauCentral.Model.Enum.Role;
import com.RestauCentral.RestauCentral.Model.Restaurant;
import com.RestauCentral.RestauCentral.Model.Utilisateur;
import com.RestauCentral.RestauCentral.Repository.ClientRepository;
import com.RestauCentral.RestauCentral.auth.AuthenticationRequest;
import com.RestauCentral.RestauCentral.auth.RegisterRequest;
import com.platformtrasnport.platformtransport.auth.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final ClientRepository clientRepository;  // Repository to interact with the database
    private final PasswordEncoder passwordEncoder;    // For password encoding
    private final JwtService jwtService;              // JWT utility service
    private final AuthenticationManager authenticationManager;  // For managing authentication

    public AuthenticationResponse registerAdmin(RegisterRequest request) {
        Client admin = new Admin();  // Using Client as reference, Admin as instance
        admin.setUsername(request.getUsername());
        admin.setEmail(request.getEmail());
        admin.setPassword(passwordEncoder.encode(request.getPassword()));
        admin.setRole(Role.ADMIN);
        clientRepository.save(admin);

        var jwtToken = jwtService.generateToken(admin, admin.getId());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse registerUtilisateur(RegisterRequest request) {
        Client utilisateur = new Utilisateur();  // Using Client as reference, Utilisateur as instance
        utilisateur.setUsername(request.getUsername());
        utilisateur.setEmail(request.getEmail());
        utilisateur.setPassword(passwordEncoder.encode(request.getPassword()));
        utilisateur.setRole(Role.USER);
        clientRepository.save(utilisateur);

        var jwtToken = jwtService.generateToken(utilisateur, utilisateur.getId());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse registerRestaurant(RegisterRequest request) {
        Client restaurant = new Restaurant();  // Using Client as reference, Restaurant as instance
        restaurant.setUsername(request.getUsername());
        restaurant.setEmail(request.getEmail());
        restaurant.setPassword(passwordEncoder.encode(request.getPassword()));
        restaurant.setRole(Role.RESTAURANT);
        clientRepository.save(restaurant);

        var jwtToken = jwtService.generateToken(restaurant, restaurant.getId());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var client = clientRepository.findByEmail(request.getEmail());
        var jwtToken = jwtService.generateToken(client, client.getId());

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .userId(client.getId())
                .build();
    }
}
