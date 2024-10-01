package com.RestauCentral.RestauCentral.Controller;

import com.RestauCentral.RestauCentral.Service.AuthenticationService;
import com.RestauCentral.RestauCentral.auth.AuthenticationRequest;
import com.RestauCentral.RestauCentral.auth.RegisterRequest;
import com.platformtrasnport.platformtransport.auth.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200/")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authService;

    @PostMapping("/register/registerAdmin")
    public ResponseEntity<AuthenticationResponse> registerAdmin(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authService.registerAdmin(request));
    }

    @PostMapping("/register/registerUtilisateur")
    public ResponseEntity<AuthenticationResponse> registerUtilisateur(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authService.registerUtilisateur(request));
    }

    @PostMapping("/register/registerRestaurant")
    public ResponseEntity<AuthenticationResponse> registerRestaurant(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authService.registerRestaurant(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
