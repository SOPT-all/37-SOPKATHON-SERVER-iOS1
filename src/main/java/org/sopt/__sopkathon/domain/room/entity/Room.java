package org.sopt.__sopkathon.domain.room.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.__sopkathon.domain.roommateinfo.entity.RoommateInfo;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Room {

    @Column(name="room_id",nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private int monthlyRent;

    @Column(nullable = false)
    private int roomCount;

    @Column(nullable = false)
    private int bathroomCount;

    @Column(nullable = false)
    private String period;

    @OneToOne(fetch = FetchType.LAZY)
    private RoommateInfo roommateInfo;
}
