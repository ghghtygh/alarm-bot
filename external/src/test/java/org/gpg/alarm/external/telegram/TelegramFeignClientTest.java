package org.gpg.alarm.external.telegram;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.gpg.alarm.external.ExternalTestConfig;
import org.gpg.alarm.external.telegram.client.TelegramClient;
import org.gpg.alarm.external.telegram.dto.request.TelegramSendMessageRequest;
import org.gpg.alarm.external.telegram.dto.response.Chat;
import org.gpg.alarm.external.telegram.dto.response.GetMe;
import org.gpg.alarm.external.telegram.dto.response.SendMessage;
import org.gpg.alarm.external.telegram.dto.response.TelegramResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;

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
    // @Value("${test.threadId")
    // private String threadId;

    @Test
    @DisplayName("봇 정보 조회 성공")
    void getMeSuccess() {
        //given
        String botToken = this.botToken;

        //when
        TelegramResponse<GetMe> response = telegramClient.getMe(botToken);

        //then
        log.info("### response : {}", response);
        assertEquals(true, response.ok());
        assertNotNull(response.result());
        assertNotNull(response.result().id());
        assertNotNull(response.result().username());
    }

    @Test
    @DisplayName("채팅방 메시지 전송 성공")
    void sendMessageChatRoomSuccess() throws Exception {
        //given
        String botToken = this.botToken;
        String text = getTestMessage();
        String requestStr = "{"
            + "\"chat_id\":\"" + this.chatId + "\""
            + ", \"message_thread_id\" : \"\""
            + ",\"text\":\"" + text + "\""
            + "}";
        TelegramSendMessageRequest sendMessageRequest = objectMapper.readValue(requestStr,
            TelegramSendMessageRequest.class);

        //when
        TelegramResponse<SendMessage> response = telegramClient.sendMessage(botToken, sendMessageRequest);

        //then
        log.info("### response : {}", response);
        SendMessage sendMessage = response.result();
        Chat chat = sendMessage.chat();
        assertEquals(true, response.ok());
        assertEquals(text.replaceAll("\\n|\\r\\n|\\\\n", ""), sendMessage.text().replaceAll("\\n|\\r\\n|\\\\n", ""));
        assertEquals(this.chatId, chat.id());
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