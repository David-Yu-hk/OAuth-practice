package com.oauthPractice.authorizetion.model.discord;

import lombok.Data;

// Discord Role Object Reference: https://discord.com/developers/docs/topics/permissions#role-object
@Data
public class DiscordRole {
    private Long id;
    private String name;
    private Integer color;
    private Colors colors;
    private boolean hoist;
    private String icon;
    private String unicodeEmoji;
    private Integer position;
    private String permissions;
    private boolean managed;
    private boolean mentionable;
    private Tags tags;
    private Integer flags;

}

class Colors {
    private Integer primaryColor;
    private Integer secondaryColor;
    private Integer tertiaryColor;
}

class Tags {
    private Long botId;
    private Long integrationId;
    private boolean premiumSubscriber;
    private Long subscriptionListingId;
    private boolean availableForPurchase;
    private boolean guildConnections;
}
