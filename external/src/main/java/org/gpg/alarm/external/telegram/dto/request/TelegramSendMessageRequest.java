package org.gpg.alarm.external.telegram.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TelegramSendMessageRequest(
    @JsonProperty("chat_id") String chatId,
    @JsonProperty("message_thread_id") String threadId,
    String text

) {
}
