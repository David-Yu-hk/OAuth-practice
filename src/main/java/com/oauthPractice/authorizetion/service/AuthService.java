package com.oauthPractice.authorizetion.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private static final String SUCCESS_RESULT = "successful";
    public String getTestResult() {
        return SUCCESS_RESULT;
    }
}
