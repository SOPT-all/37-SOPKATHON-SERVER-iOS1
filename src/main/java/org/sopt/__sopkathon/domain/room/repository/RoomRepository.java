package org.sopt.__sopkathon.domain.room.repository;

import org.sopt.__sopkathon.domain.room.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
