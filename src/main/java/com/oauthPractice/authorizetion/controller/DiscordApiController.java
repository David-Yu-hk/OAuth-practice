package com.oauthPractice.authorizetion.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.oauthPractice.authorizetion.model.discord.DiscordGuild;
import com.oauthPractice.authorizetion.service.DiscordApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Get user guilds")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = DiscordGuild.class)))),
    })
    @GetMapping("/guilds")
    public ResponseEntity<?> getUserJoinedServer(OAuth2AuthenticationToken authentication) throws JsonProcessingException {
        return ResponseEntity.ok(discordApiService.getUserJoinedServer(authentication));
    }
}
