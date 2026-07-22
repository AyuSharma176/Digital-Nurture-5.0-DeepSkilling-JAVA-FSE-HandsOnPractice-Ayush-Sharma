package com.cognizant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import com.cognizant.config.*;
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired private AuthenticationManager authManager;
    @Autowired private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        Authentication auth = authManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                body.get("username"), body.get("password")
            )
        );
        String token = jwtTokenProvider.createToken(
            auth.getName(), List.of("ROLE_USER")
        );
        return ResponseEntity.ok(Map.of("token", token));
    }
}