package org.sopt.__sopkathon.domain.dto;

public record RoomCreateResponse(String location,
                                 int monthlyRent,
                                 int roomCount,
                                 int bathroomCount,
                                 String period,
                                 String content,
                                 int washerCount) {
}
