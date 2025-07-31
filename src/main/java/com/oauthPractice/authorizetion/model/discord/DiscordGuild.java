package com.oauthPractice.authorizetion.model.discord;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class DiscordGuild {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String name;
    private String icon;
    private String iconHash;
    private String splash;
    private String discoverySplash;
    private boolean owner;
    private Long ownerId;
    private String permissions;
    private String regions;
    private Long afkChannelId;
    private Integer afkTimeout;
    private boolean widgetEnable;
    private Long widgetChannelId;
    private Integer verificationLevel;
    private Integer defaultMessageNotification;
    private Integer explicitContentFilter;
    private List<DiscordRole> roles;
    private List<DiscordEmoji> emojis;
    private List<String> features;
    private Integer mfaLevel;
    private Long applicationId;
    private Long systemChannelId;
    private Long rolesChannelId;
    private Integer maxPresences;
    private Integer maxMembers;
    private String vanityUrlCode;
    private String description;
    private String banner;
    private Integer premiumTier;
    private Integer preferredLocale;
    private Long publicUpdatesChannelId;
    private Integer maxVideoChannelUsers;
    private Integer maxStageVideoChannelUsers;
    private Integer approximateMemberCount;
    private Integer approximatePresenceCount;
    private DiscordWelcomeScreen welcomeScreen;
    private Integer nsfwLevel;
    private List<DiscordSticker> stickers;
    private boolean premiumProgressBarEnabled;
    private Long safetyAlertsChannelId;
    private IncidentsData incidentsData;
}

class IncidentsData {
    private LocalDateTime invitesDisabledUntil;
    private LocalDateTime dmsDisabledUntil;
    private LocalDateTime dmSpamDetected;
    private LocalDateTime raidDetectedAt;
}
