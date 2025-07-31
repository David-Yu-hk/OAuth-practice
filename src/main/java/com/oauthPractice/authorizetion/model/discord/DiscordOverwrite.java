package com.oauthPractice.authorizetion.model.discord;

import lombok.Data;

@Data
public class DiscordOverwrite {
    private Long id;
    private Integer type;
    private String allow;
    private String deny;
}
