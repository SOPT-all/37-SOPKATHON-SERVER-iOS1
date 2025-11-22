package org.sopt.__sopkathon.domain.roommateinfo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.__sopkathon.domain.room.entity.Room;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoommateInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="roommateinfo_id",nullable = false)
    private Long id;

    @Column(columnDefinition = "LONGTEXT")
    private String content;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    public static RoommateInfo create(String content, Room room) {
        RoommateInfo roommateInfo = RoommateInfo.builder()
                .content(content)
                .room(room)
                .build();
        return roommateInfo;
    }


}
