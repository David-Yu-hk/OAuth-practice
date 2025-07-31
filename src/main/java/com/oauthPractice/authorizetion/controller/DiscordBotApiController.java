package com.oauthPractice.authorizetion.controller;

import com.oauthPractice.authorizetion.model.discord.DiscordChannel;
import com.oauthPractice.authorizetion.service.DiscordBotApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discord/bot")
public class DiscordBotApiController {
    @Autowired
    private DiscordBotApiService discordBotApiService;

    @Operation(summary = "Get user guild's channels")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = DiscordChannel.class)))),
    })
    @GetMapping("/guilds/{guildId}/channels")
    public ResponseEntity<?> getServerChannelsId(@PathVariable Long guildId) {
        return ResponseEntity.ok(discordBotApiService.getServerChannelsId(guildId));
    }
}
