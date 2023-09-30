package org.gpg.alarm.external.telegram.client;

import org.gpg.alarm.external.telegram.dto.request.TelegramSendMessageRequest;
import org.gpg.alarm.external.telegram.dto.response.GetMe;
import org.gpg.alarm.external.telegram.dto.response.SendMessage;
import org.gpg.alarm.external.telegram.dto.response.TelegramResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "telegramClient", url = "${telegramClient.url}")
public interface TelegramClient {

    @GetMapping("/bot{botToken}/getMe")
    TelegramResponse<GetMe> getMe(@PathVariable("botToken") String botToken);

    @GetMapping("/bot{botToken}/sendMessage")
    TelegramResponse<SendMessage> sendMessage(@PathVariable("botToken") String botToken, TelegramSendMessageRequest request);
}
