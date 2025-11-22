package org.sopt.__sopkathon.domain.roommateinfo.errorcode;

import lombok.RequiredArgsConstructor;
import org.sopt.__sopkathon.global.exception.errorcode.ErrorCode;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum RoommateErrorCode implements ErrorCode {
    ROOMMATE_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "룸메이트 정보가 존재하지 않습니다."),
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
