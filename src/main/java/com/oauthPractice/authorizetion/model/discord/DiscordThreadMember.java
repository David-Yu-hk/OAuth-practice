package com.oauthPractice.authorizetion.model.discord;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DiscordThreadMember {
    private Long id;
    private Long userId;
    private LocalDateTime joinTimestamp;
    private Integer flags;
    private DiscordGuildMember guildMember;
}
