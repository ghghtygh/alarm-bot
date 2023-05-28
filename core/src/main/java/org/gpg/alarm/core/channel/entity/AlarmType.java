package org.gpg.alarm.core.channel.entity;

import lombok.Getter;

@Getter
public enum AlarmType {
    TELEGRAM(Values.TELEGRAM),
    ;

    private String name;

    AlarmType(String val) {
        if (!this.name().equals(val))
            throw new IllegalArgumentException("invalid alarm type");
    }

    public static class Values {
        public static final String TELEGRAM = "telegram";
    }
}
