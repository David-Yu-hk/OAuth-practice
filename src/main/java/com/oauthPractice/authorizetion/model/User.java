package com.oauthPractice.authorizetion.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotBlank;

@Data
@Document(collection = "user")
public class User {
    @Id
    private String id;
    @NotBlank(message = "Username is required")
    private String username;
    @NotBlank(message = "Password is required")
    private String password;
    private List<UserAuthority> authorityList = new ArrayList<>();
}
