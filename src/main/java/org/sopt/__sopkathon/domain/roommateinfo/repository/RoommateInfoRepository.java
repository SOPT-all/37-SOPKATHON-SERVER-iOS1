package org.sopt.__sopkathon.domain.roommateinfo.repository;

import org.sopt.__sopkathon.domain.room.entity.Room;
import org.sopt.__sopkathon.domain.roommateinfo.entity.RoommateInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoommateInfoRepository extends JpaRepository<RoommateInfo, Integer> {

    Optional<RoommateInfo> findByRoom(Room room);
}
