package org.gpg.alarm.external.telegram.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record From(
    String id,
    @JsonProperty("is_bot") Boolean isBot,
    @JsonProperty("first_name") String firstName,
    String username
) {
}
