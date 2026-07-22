package com.cognizant.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class UserController {

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OidcUser principal) {
        return Map.of(
            "name",  principal.getFullName(),
            "email", principal.getEmail(),
            "sub",   principal.getSubject(),
            "claims", principal.getClaims()
        );
    }
}
