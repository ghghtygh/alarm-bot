package org.gpg.alarm.external.telegram;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.HttpStatus.Series.*;

import java.time.LocalDateTime;

import org.gpg.alarm.external.ExternalTestConfig;
import org.gpg.alarm.external.telegram.client.TelegramClient;
import org.gpg.alarm.external.telegram.dto.request.TelegramSendMessageRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;

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

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${test.botToken}")
    private String botToken;
    @Value("${test.chatId}")
    private String chatId;
    @Value("${test.threadId")
    private String threadId;

    @Test
    @DisplayName("봇 정보 조회 성공")
    void getMeSuccess() throws Exception {
        //given
        String botToken = this.botToken;

        //when
        Response response = telegramClient.getMe(botToken);

        //then
        log.info("### body : {}", response.body());
        assertEquals(HttpStatus.Series.valueOf(response.status()), SUCCESSFUL);
    }

    @Test
    @DisplayName("채팅방 메시지 전송 성공")
    void sendMessageChatRoomSuccess() throws Exception {
        //given
        String botToken = this.botToken;
        String text = getTestMessage();
        String requestStr = "{"
            + "\"chat_id\":\"" + this.chatId + "\""
            // + ", \"message_thread_id\" : \"\""
            + ",\"text\":\"" + text + "\""
            + "}";
        TelegramSendMessageRequest sendMessageRequest = objectMapper.readValue(requestStr,
            TelegramSendMessageRequest.class);

        //when
        Response response = telegramClient.sendMessage(botToken, sendMessageRequest);

        //then
        log.info("### body : {}", response.body());
        assertEquals(HttpStatus.Series.valueOf(response.status()), SUCCESSFUL);
    }

    @Test
    @DisplayName("채팅 그룹 메시지 전송 성공")
    void sendMessageChatGroupSuccess() throws Exception {
        //given

        //when

        //then
    }

    private String getTestMessage() {
        StackTraceElement thisStackTraceElement = Thread.currentThread().getStackTrace()[2];
        String className = thisStackTraceElement.getClassName();
        String methodName = thisStackTraceElement.getMethodName();
        return "[채팅방 메시지 전송 테스트]"
            + "\\n클래스명 : " + className
            + "\\n메서드명 : " + methodName
            + "\\n테스트일시 : " + LocalDateTime.now();
    }
}