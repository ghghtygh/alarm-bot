package org.gpg.alarm.external.telegram.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SendMessage(
    @JsonProperty("message_id") String messageId,
    From from,
    Chat chat,
    Long date,
    String text
) {
}