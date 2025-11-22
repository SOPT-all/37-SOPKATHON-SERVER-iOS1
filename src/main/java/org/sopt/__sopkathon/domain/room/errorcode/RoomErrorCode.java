package org.sopt.__sopkathon.domain.room.errorcode;

import lombok.RequiredArgsConstructor;
import org.sopt.__sopkathon.global.exception.errorcode.ErrorCode;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum RoomErrorCode implements ErrorCode {
    ROOM_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "존재하지 않는 방입니다.")
    ;


    private final int httpStatus;
    private final String message;

    @Override
    public int getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;

    }
}
