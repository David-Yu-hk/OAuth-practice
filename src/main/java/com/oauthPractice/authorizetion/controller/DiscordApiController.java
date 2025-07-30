package com.oauthPractice.authorizetion.controller;

import com.oauthPractice.authorizetion.service.DiscordApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discord")
@RequiredArgsConstructor
public class DiscordApiController {
    @Autowired
    private DiscordApiService discordApiService;

    @GetMapping("/guilds")
    public ResponseEntity<String> getUserJoinedServer(OAuth2AuthenticationToken authentication) {
        String response = discordApiService.getUserJoinedServer(authentication);
        return ResponseEntity.ok(response);
    }

}
