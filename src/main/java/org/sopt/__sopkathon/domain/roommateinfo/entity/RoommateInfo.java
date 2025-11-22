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

    @Column(nullable = false)
    private String content;

    @OneToOne(fetch = FetchType.LAZY)
    private Room room;
}
