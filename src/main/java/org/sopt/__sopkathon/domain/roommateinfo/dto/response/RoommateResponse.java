package org.sopt.__sopkathon.domain.roommateinfo.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import org.sopt.__sopkathon.domain.roommateinfo.entity.RoommateInfo;

public record RoommateResponse(
        @Schema(description = "룸메이트 소개서", example = "제 룸메는요...")
        String content
) {
    public static RoommateResponse from(RoommateInfo roommateInfo) {
        return new RoommateResponse(roommateInfo.getContent());
    }
}
