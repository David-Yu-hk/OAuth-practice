package com.oauthPractice.authorizetion.model.discord;

import lombok.Data;

import java.util.List;

@Data
public class DiscordEmoji {
    private Long id;
    private String name;
    private List<DiscordRole> roles;
    private DiscordUser user;
    private boolean requiredColons;
    private boolean managed;
    private boolean animated;
    private boolean available;
}
