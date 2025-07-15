package com.oauthPractice.authorizetion.service;

import com.oauthPractice.authorizetion.model.User;
import com.oauthPractice.authorizetion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String createUser(User user) {
        String encodedPwd = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPwd);
        user.setId(null);
        userRepository.insert(user);
        return user.getId();
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
