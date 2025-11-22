package org.sopt.__sopkathon.domain.dto;

import org.sopt.__sopkathon.domain.room.entity.Cleanliness;
import org.sopt.__sopkathon.domain.room.entity.DrinkingCapacity;
import org.sopt.__sopkathon.domain.room.entity.HomeFrequency;
import org.sopt.__sopkathon.domain.room.entity.Smoke;

public record RoomCreateRequest(String location,
                                int monthlyRent,
                                int roomCount,
                                int bathroomCount,
                                String period,
                                int intimacy,
                                HomeFrequency homeFrequency,
                                DrinkingCapacity drinkingCapacity,
                                Cleanliness cleanliness,
                                Smoke smoke,
                                int washerCount) {
}
