package org.sopt.__sopkathon.domain.room.entity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Cleanliness {
    PERFECT_CLEAN("먼지 한톨도 용납 못해요"),
    IMMEDIALTELY_CLEAN("바로바로 치워요"),
    ALL_AT_ONCE_CLEAN("몰아서 치워요"),
    LITTLE_DIRTY_OK("조금 더러워도 괜찮아요");

    private final String description;
}
