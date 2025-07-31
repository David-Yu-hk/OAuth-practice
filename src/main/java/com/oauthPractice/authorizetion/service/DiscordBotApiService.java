package com.oauthPractice.authorizetion.service;

import com.oauthPractice.authorizetion.model.discord.DiscordChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class DiscordBotApiService {
    @Value("${spring.security.oauth2.provider.discord.bot.token}")
    private String BOT_TOKEN;
    @Value("${discord.base.url}")
    private String DISCORD_API_BASE_URL;

    public List<DiscordChannel> getServerChannelsId(Long guildId) {
        String botToken = "Bot " + BOT_TOKEN;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", botToken);
        log.debug("Bot token:{}", botToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<DiscordChannel>> response = restTemplate.exchange(
                DISCORD_API_BASE_URL + "/guilds/" + guildId + "/channels",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<>() {}
        );

        return response.getBody();
    }
}
