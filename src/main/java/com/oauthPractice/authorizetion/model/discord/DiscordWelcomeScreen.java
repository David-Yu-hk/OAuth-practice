package com.oauthPractice.authorizetion.model.discord;

import lombok.Data;

import java.util.List;

@Data
public class DiscordWelcomeScreen {
    private String description;
    private List<WelcomeScreenChannel> welcomeScreenChannels;
}

class WelcomeScreenChannel {
    private Long channelId;
    private String description;
    private Long emojiId;
    private String emojiName;
}
