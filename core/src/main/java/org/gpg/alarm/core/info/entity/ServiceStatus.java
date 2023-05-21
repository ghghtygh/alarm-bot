package org.gpg.alarm.core.info.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ServiceStatus {

    ENABLE("enable"),
    DISABLE("disable"),
    SUSPEND("suspend"),
    ;

    private final String code;
}
