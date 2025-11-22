package org.sopt.__sopkathon.domain.room.entity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Smoke {
    NO("담배 안펴요"),
    YES("담배 펴요");

    private final String description;
}
