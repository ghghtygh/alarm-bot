package org.gpg.alarm.info.application.dto.request;

import java.util.List;

public record ServiceInfoRequest(
    String serviceName,
    String sendTime,
    String alarmFormat,
    List<Long> channelIdList
) {
}
