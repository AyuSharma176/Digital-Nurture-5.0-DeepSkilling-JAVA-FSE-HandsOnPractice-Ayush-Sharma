package com.cognizant.controllers;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class SecureController {

    @GetMapping("/public/hello")
    public String publicEndpoint() {
        return "This is a public endpoint — no token needed.";
    }

    @GetMapping("/secure")
    public Map<String, String> secure(Authentication auth) {
        return Map.of(
            "message", "Access granted to secure endpoint",
            "user", auth.name()
        );
    }

    @GetMapping("/admin/data")
    @PreAuthorize("hasAuthority('SCOPE_admin')")
    public String adminEndpoint() {
        return "Admin-only endpoint — requires 'admin' scope.";
    }
}
