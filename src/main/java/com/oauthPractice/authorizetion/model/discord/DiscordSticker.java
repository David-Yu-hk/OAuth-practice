package com.oauthPractice.authorizetion.model.discord;

import lombok.Data;

// Discord Sticker Object: https://discord.com/developers/docs/resources/sticker#sticker-object
@Data
public class DiscordSticker {
    private Long id;
    private long packId;
    private String name;
    private String description;
    private String tags;
    private Integer type;
    private Integer formatType;
    private boolean available;
    private Long guildId;
    private DiscordUser user;
    private Integer sortValue;

}
