package org.sopt.__sopkathon.global.config.swagger;

import lombok.Getter;
import org.sopt.__sopkathon.domain.room.errorcode.RoomErrorCode;
import org.sopt.__sopkathon.domain.roommateinfo.errorcode.RoommateErrorCode;
import org.sopt.__sopkathon.global.exception.errorcode.ErrorCode;
import org.sopt.__sopkathon.global.exception.errorcode.GlobalErrorCode;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.sopt.__sopkathon.domain.room.errorcode.RoomErrorCode.*;
import static org.sopt.__sopkathon.domain.roommateinfo.errorcode.RoommateErrorCode.*;

@Getter
public enum SwaggerResponseDescription {
    COMMON(new LinkedHashSet<>(Set.of(
    ))),
    GET_ROOMMATE_INFO(new LinkedHashSet<>(Set.of(
            ROOMMATE_NOT_FOUND,
            ROOM_NOT_FOUND
    )))

    ;
    private final Set<ErrorCode> errorCodeList;
    SwaggerResponseDescription(Set<ErrorCode> specificErrorCodes) {
        this.errorCodeList = new LinkedHashSet<>();
        this.errorCodeList.addAll(specificErrorCodes);
        this.errorCodeList.addAll(getGlobalErrorCodes());
    }

    private Set<ErrorCode> getGlobalErrorCodes() {
        return new LinkedHashSet<>(Set.of(GlobalErrorCode.values()));
    }
}
