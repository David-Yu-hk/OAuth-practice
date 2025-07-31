package com.oauthPractice.authorizetion.model.discord;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class DiscordChannel {
    private String id;
    private Integer type;
    private Long guildId;
    private Integer position;
    private List<DiscordOverwrite> permissionOverwrites;
    private String name;
    private String topic;
    private boolean nsfw;
    private Long lastMessageId;
    private Integer bitrate;
    private Integer userLimit;
    private Integer rateLimitPerUser;
    private List<DiscordUser> recipients;
    private String icon;
    private Long ownerId;
    private Long applicationId;
    private boolean managed;
    private Long parentId;
    private LocalDateTime lastPinTimestamp;
    private String rtcRegion;
    private Integer videoQualityMode;
    private Integer messageCount;
    private Integer memberCount;
    private List<DiscordThreadMetadata> threadMetadata;
    private List<DiscordThreadMember> member;
    private Integer defaultAutoArchiveDuration;
    private String permissions;
    private Integer flags;
    private Integer totalMessageSent;
    private List<Tag> availableTags;
    private DefaultReaction defaultReactionEmoji;
    private Integer defaultThreadRateLimitPerUser;
    private Integer defaultSortOrder;
    private Integer defaultForumLayout;
}

class Tag {
    private Long id;
    private String name;
    private boolean moderated;
    private Long emojiId;
    private String emojiName;
}

class DefaultReaction {
    private Long emojiId;
    private String emojiName;

}
