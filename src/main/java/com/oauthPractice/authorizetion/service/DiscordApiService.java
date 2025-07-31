package com.oauthPractice.authorizetion.service;

import com.oauthPractice.authorizetion.model.discord.DiscordGuild;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

@Slf4j
@Service
public class DiscordApiService {
    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;
    @Value("${discord.base.url}")
    private String DISCORD_API_BASE_URL;

    private String getAccessToken(OAuth2AuthenticationToken authentication) {
        OAuth2AuthorizedClient client = authorizedClientService.loadAuthorizedClient(
                authentication.getAuthorizedClientRegistrationId(),
                authentication.getName()
        );

        return client.getAccessToken().getTokenValue();
    }

    public List<DiscordGuild> getUserJoinedServer(OAuth2AuthenticationToken authentication) {
        String accessToken = getAccessToken(authentication);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        headers.set("User-Agent", "SpringBootApp");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        log.info("Discord guilds api: {}", DISCORD_API_BASE_URL + "/users/@me/guilds");
        ResponseEntity<List<DiscordGuild>> response = restTemplate.exchange(
                DISCORD_API_BASE_URL + "/users/@me/guilds",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<>() {}
        );

        return response.getBody();
    }
}
