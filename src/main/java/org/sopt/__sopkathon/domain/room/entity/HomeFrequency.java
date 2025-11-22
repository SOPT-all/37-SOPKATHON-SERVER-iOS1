package org.sopt.__sopkathon.domain.room.entity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum HomeFrequency {
    ONLY_SLEEP_AT_HOME("잠만 자고 나가요"),
    DINNER_AT_HOME("저녁은 집에서"),
    USUALLY_AT_HOME("주로 집에 있어요"),
    RARELY_OUTSIDE("밖을 잘 안나가요");

    private final String description;

}
