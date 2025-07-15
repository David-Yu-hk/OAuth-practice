package com.oauthPractice.security;

public interface PasswordEncoder {
    String encode(CharSequence rawPassword);
    boolean match(CharSequence rawPassword, String encodedPassword);
}
