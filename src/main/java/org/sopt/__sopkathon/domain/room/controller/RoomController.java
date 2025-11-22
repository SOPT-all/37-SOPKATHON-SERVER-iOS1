package org.sopt.__sopkathon.domain.room.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.sopt.__sopkathon.domain.roommateinfo.dto.response.RoommateResponse;
import org.sopt.__sopkathon.domain.roommateinfo.service.RoommateInfoService;
import org.sopt.__sopkathon.global.annotation.CustomExceptionDescription;
import org.sopt.__sopkathon.global.config.swagger.SwaggerResponseDescription;
import org.sopt.__sopkathon.global.dto.response.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.sopt.__sopkathon.global.config.swagger.SwaggerResponseDescription.*;

@RestController
@RequestMapping("rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoommateInfoService roommateInfoService;

    @Operation(summary = "룸메이트 소개서 조회")
    @GetMapping("{roomId}/roommmate")
    @CustomExceptionDescription(GET_ROOMMATE_INFO)
    public BaseResponse<RoommateResponse> getRoommmateInfo(@PathVariable Long roomId) {
        return BaseResponse.ok(roommateInfoService.getRoommateInfo(roomId),"룸메이트 소개서 조회 성공");
    }

}
