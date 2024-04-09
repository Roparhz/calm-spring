package com.project.calm.controllers;

import com.project.calm.config.JwtService;
import com.project.calm.config.LoginRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public Map<String, String> connexion(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        if(authentication.isAuthenticated()){
           return this.jwtService.generate(loginRequest.getEmail());
        }

        System.out.print(authentication.isAuthenticated() + "test");

        return null;
    }
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@CookieValue(value = "access_token", required = false) String accessToken) {
        if (accessToken != null) {
            // Supprimez le token JWT du client en utilisant l'en-tête HTTP Set-Cookie
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.SET_COOKIE, "access_token=; Max-Age=0; Path=/; HttpOnly");
        }
        System.out.println("tamere");
        // Retourne une réponse HTTP 204 (No Content) pour indiquer que la déconnexion a réussi
        return ResponseEntity.noContent().build();
    }

}
