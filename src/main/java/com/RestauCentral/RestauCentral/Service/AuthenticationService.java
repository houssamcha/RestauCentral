package com.RestauCentral.RestauCentral.Service;

import com.RestauCentral.RestauCentral.Model.Enum.Role;
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

    private final ClientRepository userRepository;  // Repository to interact with database
    private final PasswordEncoder passwordEncoder;      // For password encoding
    private final JwtService jwtService;                // JWT utility service
    private final AuthenticationManager authenticationManager;  // For managing authentication

    public AuthenticationResponse registerAdmin(RegisterRequest request) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUsername(request.getUsername());
        utilisateur.setEmail(request.getEmail());
        utilisateur.setPassword(passwordEncoder.encode(request.getPassword()));
        utilisateur.setRole(Role.ADMIN);
        userRepository.save(utilisateur);

        var jwtToken = jwtService.generateToken(utilisateur, utilisateur.getId());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse registerUtilisateur(RegisterRequest request) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUsername(request.getUsername());
        utilisateur.setEmail(request.getEmail());
        utilisateur.setPassword(passwordEncoder.encode(request.getPassword()));
        utilisateur.setRole(Role.USER);
        userRepository.save(utilisateur);

        var jwtToken = jwtService.generateToken(utilisateur, utilisateur.getId());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse registerRestaurant(RegisterRequest request) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUsername(request.getUsername());
        utilisateur.setEmail(request.getEmail());
        utilisateur.setPassword(passwordEncoder.encode(request.getPassword()));
        utilisateur.setRole(Role.RESTAURANT);
        userRepository.save(utilisateur);

        var jwtToken = jwtService.generateToken(utilisateur, utilisateur.getId());
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

        var user = userRepository.findByEmail(request.getEmail());
        var jwtToken = jwtService.generateToken(user, user.getId());

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .userId(user.getId())
                .build();
    }
}
