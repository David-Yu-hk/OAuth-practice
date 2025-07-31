package com.oauthPractice.authorizetion.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oauthPractice.authorizetion.model.discord.DiscordGuild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DiscordApiService {
    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;
    private static final String DISCORD_API_BASE_URL = "https://discord.com/api";

    public List<DiscordGuild> getUserJoinedServer(OAuth2AuthenticationToken authentication) throws JsonProcessingException {
        OAuth2AuthorizedClient client = authorizedClientService.loadAuthorizedClient(
                authentication.getAuthorizedClientRegistrationId(),
                authentication.getName()
        );

        String accessToken = client.getAccessToken().getTokenValue();

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        headers.set("User-Agent", "SpringBootApp");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<DiscordGuild>> response = restTemplate.exchange(
                DISCORD_API_BASE_URL + "/users/@me/guilds",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<DiscordGuild>>() {}
        );

        return response.getBody();
    }
}
