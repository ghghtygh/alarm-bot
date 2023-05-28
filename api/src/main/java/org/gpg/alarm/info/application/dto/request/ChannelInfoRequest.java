package org.gpg.alarm.info.application.dto.request;

public record ChannelInfoRequest(
    String botAlias,
    String botToken,
    String chatId,
    String threadId,
    String alarmType
) {
}
