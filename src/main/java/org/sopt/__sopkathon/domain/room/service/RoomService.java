package org.sopt.__sopkathon.domain.room.service;

import lombok.RequiredArgsConstructor;
import org.sopt.__sopkathon.domain.room.dto.request.RoomCreateRequest;
import org.sopt.__sopkathon.domain.room.constant.PromptMessage;
import org.sopt.__sopkathon.domain.room.dto.response.RoomResponse;
import org.sopt.__sopkathon.domain.room.dto.response.RoommateInfoResponse;
import org.sopt.__sopkathon.domain.room.entity.Room;
import org.sopt.__sopkathon.domain.room.repository.RoomRepository;
import org.sopt.__sopkathon.domain.roommateinfo.entity.RoommateInfo;
import org.sopt.__sopkathon.domain.roommateinfo.repository.RoommateInfoRepository;
import org.sopt.__sopkathon.global.external.openai.client.OpenAiClient;
import org.sopt.__sopkathon.global.external.openai.dto.request.ChatRequestMessage;
import org.sopt.__sopkathon.global.exception.customexception.CustomException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import static org.sopt.__sopkathon.domain.room.errorcode.RoomErrorCode.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoommateInfoRepository roommateInfoRepository;
    private final OpenAiClient openAiClient;

    @Transactional
    public RoommateInfoResponse createRoom(RoomCreateRequest request) {

        Room room = Room.create(request.location(),
                request.monthlyRent(),
                request.roomCount(),
                request.bathroomCount(),
                request.period(),
                request.washerCount()
        );

        roomRepository.save(room);

        String content = openAiClient.sendRequest(List.of(
                new ChatRequestMessage("system", PromptMessage.SYSTEM_PROMPT),
                new ChatRequestMessage("user",String.format(PromptMessage.USER_PROMPT,
                        request.intimacy(),
                        request.homeFrequency(),
                        request.drinkingCapacity(),
                        request.cleanliness(),
                        request.smoke()))));

        RoommateInfo roommateInfo = RoommateInfo.create(content, room);

        roommateInfoRepository.save(roommateInfo);

        return RoommateInfoResponse.from(roommateInfo);
    }
    public RoomResponse getRoomInfo(Long roomId) {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new CustomException(ROOM_NOT_FOUND));

        return RoomResponse.from(room);

    }
}
