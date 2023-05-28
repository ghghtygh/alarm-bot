package org.gpg.alarm.send.application.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SendMessageRequest(
    @JsonProperty("message") String message,
    @JsonProperty("key") String key
    ) {

}
