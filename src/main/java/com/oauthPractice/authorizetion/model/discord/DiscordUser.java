package com.oauthPractice.authorizetion.model.discord;

import lombok.Data;

//Discord User Object reference: https://discord.com/developers/docs/resources/user
@Data
public class DiscordUser {
    private Long id;
    private String username;
    private String discriminator;
    private String globalName;
    private String avatar;
    private boolean bot;
    private boolean system;
    private boolean mfaEnabled;
    private String banner;
    private Integer accentColor;
    private String locale;
    private boolean verified;
    private String email;
    private Integer flags;
    private Integer premium_type;
    private Integer public_flags;
    private AvatarDecorationData avatarDecorationData;
    private Collectibles collectibles;
    private PrimaryGuild primaryGuild;
}

class AvatarDecorationData {
    private Long skuId;
    private String asset;
}

class Collectibles {
    private Nameplate nameplate;
}

class Nameplate {
    private Long skuId;
    private String asset;
    private String label;
    private String palette;
}

class PrimaryGuild {
    private Long identityGuildId;
    private boolean identityEnabled;
    private String tag;
    private String badge;
}

