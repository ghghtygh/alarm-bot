package org.gpg.alarm.external.telegram.dto.response;

public record TelegramResponse<T>(
    Boolean ok,
    T result
) {
}
