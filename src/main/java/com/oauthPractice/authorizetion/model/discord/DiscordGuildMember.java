package com.oauthPractice.authorizetion.model.discord;

import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class DiscordGuildMember {
    private DiscordUser user;
    private String nick;
    private String avatar;
    private String banner;
    private List<Long> roles;
    private LocalDateTime joinedAt;
    private LocalDateTime premiumSince;
    private boolean deaf;
    private boolean mute;
    private Integer flags;
    private boolean pending;
    private String permissions;
    private LocalDateTime communicationDisableUntil;
    private DiscordAvatarDecorationData avatarDecorationData;
}
