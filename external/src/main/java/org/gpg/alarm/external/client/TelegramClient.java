package org.gpg.alarm.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import feign.Response;

@FeignClient(name = "telegramClient", url = "${telegramClient.url}")
public interface TelegramClient {

    @GetMapping("/bot{botToken}/getMe")
    Response getMe(@PathVariable("botToken") String botToken);
}
