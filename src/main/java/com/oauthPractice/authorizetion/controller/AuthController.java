package com.oauthPractice.authorizetion.controller;

import com.oauthPractice.authorizetion.model.User;
import com.oauthPractice.authorizetion.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("user")
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok(authService.createUser(user));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("user")
    public ResponseEntity<?> getUsers() {
        try {
            return ResponseEntity.ok(authService.getUsers());
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(403).body("User not found or unauthorized");
        }
    }

    @GetMapping("hello")
    public String home() {
        return "hello";
    }
}
