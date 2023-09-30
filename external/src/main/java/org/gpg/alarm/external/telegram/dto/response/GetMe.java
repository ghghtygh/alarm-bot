package org.gpg.alarm.external.telegram.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GetMe(
    String id,
    @JsonProperty("is_bot") Boolean isBot,
    String username,
    @JsonProperty("can_join_groups") Boolean canJoinGroups,
    @JsonProperty("can_read_all_group_messages") Boolean canReadAllGroupMessages,
    @JsonProperty("supports_inline_queries") Boolean supportsInlineQueries
) {
}
