package com.oauthPractice.authorizetion.model.discord;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DiscordThreadMetadata {
    private boolean archived;
    private Integer autoArchiveDuration;
    private LocalDateTime archiveTimestamp;
    private boolean locked;
    private boolean invitable;
    private LocalDateTime createTimestamp;
}
