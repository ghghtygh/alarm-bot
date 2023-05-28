package org.gpg.alarm.common.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public record ResponseDto<T>(
    Integer code,
    String message,
    T data
) {
    public static <T> ResponseEntity<ResponseDto<T>> ok(T data) {
        return ResponseEntity.ok(new ResponseDto<>(HttpStatus.OK.value(), "", data));
    }
}
