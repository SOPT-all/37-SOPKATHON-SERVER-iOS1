package org.sopt.__sopkathon.domain.room.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.sopt.__sopkathon.domain.room.dto.request.RoomCreateRequest;
import org.sopt.__sopkathon.domain.room.dto.response.RoommateInfoResponse;
import org.sopt.__sopkathon.domain.room.service.RoomService;
import org.sopt.__sopkathon.domain.room.dto.response.RoomResponse;
import org.sopt.__sopkathon.domain.roommateinfo.dto.response.RoommateResponse;
import org.sopt.__sopkathon.domain.roommateinfo.service.RoommateInfoService;
import org.sopt.__sopkathon.global.annotation.CustomExceptionDescription;
import org.sopt.__sopkathon.global.dto.response.BaseResponse;
import org.springframework.web.bind.annotation.*;

import static org.sopt.__sopkathon.global.config.swagger.SwaggerResponseDescription.*;

@RestController
@RequestMapping("rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoommateInfoService roommateInfoService;
    private final RoomService roomService;


    @Operation(summary = "룸메이트 소개서 조회")
    @GetMapping("{roomId}/roommmate")
    @CustomExceptionDescription(GET_ROOMMATE_INFO)
    public BaseResponse<RoommateResponse> getRoommmateInfo(@PathVariable Long roomId) {
        return BaseResponse.ok(roommateInfoService.getRoommateInfo(roomId),"룸메이트 소개서 조회 성공");
    }

    @Operation(summary = "룸메이트 소개서 생성")
    @PostMapping
    @CustomExceptionDescription(COMMON)
    public BaseResponse<RoommateInfoResponse> createRoom(@RequestBody RoomCreateRequest request) {
        return BaseResponse.create(roomService.createRoom(request),"룸메이트 소개서 생성 성공");
    }


    @Operation(summary = "방 정보 조회")
    @GetMapping("{roomId}")
    @CustomExceptionDescription(GET_ROOM_INFO)
    public BaseResponse<RoomResponse> getRoomInfo(@PathVariable Long roomId) {
        return BaseResponse.ok(roomService.getRoomInfo(roomId),"방 정보 조회 성공");
    }

}
