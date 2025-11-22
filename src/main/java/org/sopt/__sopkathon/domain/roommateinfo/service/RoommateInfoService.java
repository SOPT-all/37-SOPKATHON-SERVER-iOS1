package org.sopt.__sopkathon.domain.roommateinfo.service;


import lombok.RequiredArgsConstructor;
import org.sopt.__sopkathon.domain.room.entity.Room;
import org.sopt.__sopkathon.domain.room.errorcode.RoomErrorCode;
import org.sopt.__sopkathon.domain.room.repository.RoomRepository;
import org.sopt.__sopkathon.domain.roommateinfo.dto.response.RoommateResponse;
import org.sopt.__sopkathon.domain.roommateinfo.entity.RoommateInfo;
import org.sopt.__sopkathon.domain.roommateinfo.errorcode.RoommateErrorCode;
import org.sopt.__sopkathon.domain.roommateinfo.repository.RoommateInfoRepository;
import org.sopt.__sopkathon.global.exception.customexception.CustomException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.sopt.__sopkathon.domain.room.errorcode.RoomErrorCode.*;
import static org.sopt.__sopkathon.domain.roommateinfo.errorcode.RoommateErrorCode.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RoommateInfoService {

    private final RoommateInfoRepository roommateInfoRepository;

    private final RoomRepository roomRepository;

    public RoommateResponse getRoommateInfo(Long roomId){
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new CustomException(ROOM_NOT_FOUND));

        RoommateInfo roommateInfo = roommateInfoRepository.findByRoom(room).orElseThrow(() -> new CustomException(ROOMMATE_NOT_FOUND));

        return RoommateResponse.from(roommateInfo);
    }

}
