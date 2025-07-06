package com.oauthPractice.authorizetion.controller;

import com.oauthPractice.authorizetion.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @GetMapping("/test")
    private String getTestResult() {
        return authService.getTestResult();
    }

    @GetMapping("/authTest")
    private String getAuthTestResult() {
        return authService.getTestResult();
    }
}
