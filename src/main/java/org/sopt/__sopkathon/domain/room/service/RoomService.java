package org.sopt.__sopkathon.domain.room.service;

import lombok.RequiredArgsConstructor;
import org.sopt.__sopkathon.domain.room.dto.response.RoomResponse;
import org.sopt.__sopkathon.domain.room.entity.Room;
import org.sopt.__sopkathon.domain.room.errorcode.RoomErrorCode;
import org.sopt.__sopkathon.domain.room.repository.RoomRepository;
import org.sopt.__sopkathon.global.exception.customexception.CustomException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.sopt.__sopkathon.domain.room.errorcode.RoomErrorCode.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomResponse getRoomInfo(Long roomId) {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new CustomException(ROOM_NOT_FOUND));

        return RoomResponse.from(room);
    }
}
