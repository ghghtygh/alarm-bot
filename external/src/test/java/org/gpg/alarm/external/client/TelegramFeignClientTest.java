package org.gpg.alarm.external.client;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.HttpStatus.Series.*;

import org.gpg.alarm.external.ExternalTestConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;

import feign.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ContextConfiguration(classes = {
    ExternalTestConfig.class
})
@SpringBootTest(properties = {"spring.config.location=classpath:external-test.yml"})
class TelegramFeignClientTest {

    @Autowired
    private TelegramClient telegramClient;

    @Value("${test.botToken}")
    private String botToken;

    @Test
    @DisplayName("봇 정보 조회 성공")
    void getMeSuccess() throws Exception {
        //when
        Response response = telegramClient.getMe(botToken);

        //then
        log.info("body : {}", response.body());
        assertEquals(HttpStatus.Series.valueOf(response.status()), SUCCESSFUL);
    }
}