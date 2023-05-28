package org.gpg.alarm.core.telegram.entity;

import static org.gpg.alarm.core.channel.entity.AlarmType.Values.TELEGRAM;

import org.gpg.alarm.core.channel.entity.AlarmChannel;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue(value = TELEGRAM)
public class TelegramAlarm extends AlarmChannel {
}