package org.gpg.alarm.external.client;

import org.gpg.alarm.external.dto.request.GetMeRequest;
import org.gpg.alarm.external.dto.response.GetMeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "telegramFeignClient", url = "${feign.telegram.url}")
public interface TelegramFeignClient {

    @GetMapping(value = "/getMe", produces = "application/json", consumes = "application/json")
    GetMeResponse getMe(GetMeRequest request);
}
