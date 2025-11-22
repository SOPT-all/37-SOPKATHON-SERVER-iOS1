package org.sopt.__sopkathon.domain.room.entity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum DrinkingCapacity {
    ALCOHOL_FREE("술 안마셔요"),
    ALCOHOL_LITTLE("가끔 기분만"),
    ALCOHOL_ENJOY("술 마시는걸 즐겨요"),
    ALCOHOL_LOVE("애주가에요");

    private final String description;
}
