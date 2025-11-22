package org.sopt.__sopkathon.domain.room.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import org.sopt.__sopkathon.domain.room.entity.Cleanliness;
import org.sopt.__sopkathon.domain.room.entity.DrinkingCapacity;
import org.sopt.__sopkathon.domain.room.entity.HomeFrequency;
import org.sopt.__sopkathon.domain.room.entity.Smoke;

import java.awt.*;

public record RoomCreateRequest(
        @Schema(description = "위치", example = "Paris 11구 Bastille 근처")
        String location,

        @Schema(description = "월세", example = "500")
        int monthlyRent,

        @Schema(description = "방 수 ", example = "1")
        int roomCount,

        @Schema(description = "화장실 수", example = "1")
        int bathroomCount,

        @Schema(description = "기간", example = "2025.11~2026.02")
        String period,

        @Schema(description = "친밀도", example = "100")
        int intimacy,

        @Schema(description = "집에 있는 정도", example = "집에 자주 있어요")
        String homeFrequency,

        @Schema(description = "주량", example = "술 안 마셔요")
        String drinkingCapacity,

        @Schema(description = "청결도", example = "바로바로 치워요")
        String cleanliness,

        @Schema(description = "흡연", example = "담배 펴요")
        String smoke,

        @Schema(description = "추가 설명", example = "이 분 정말 착하십니다")
        String description,

        @Schema(description = "세탁기 수 ", example = "1")
        int washerCount) {
}
