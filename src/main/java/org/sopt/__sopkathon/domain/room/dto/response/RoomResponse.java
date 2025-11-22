package org.sopt.__sopkathon.domain.room.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import org.sopt.__sopkathon.domain.room.entity.Room;

public record RoomResponse(
        @Schema(description = "위치", example = "서울특별시...")
        String location,

        @Schema(description = "월세", example = "100")
        int monthlyRent,

        @Schema(description = "기간", example = "2025.12~2026.02")
        String period,

        @Schema(description = "방 수 ", example = "1")
        int roomCount,

        @Schema(description = "화장실 수", example = "1")
        int bathroomCount,

        @Schema(description = "세탁기 수 ", example = "1")
        int washerCount
) {
    public static RoomResponse from(Room room) {
        return new RoomResponse(room.getLocation(),
                room.getMonthlyRent(),
                room.getPeriod(),
                room.getRoomCount(),
                room.getBathroomCount(),
                room.getWasherCount());
    }
}
