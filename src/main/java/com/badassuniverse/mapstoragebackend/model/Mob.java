package com.badassuniverse.mapstoragebackend.model;

import com.badassuniverse.mapstoragebackend.converter.ColorConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Embeddable
@Table(name = "mobs")
public class Mob {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//    @ManyToOne
//    @JoinColumn(name="room_id", nullable=true)
//    private Room room;

    @Convert(converter = ColorConverter.class)
    private Color color;

    private String name;
    private Integer inGameMobId;
    private Integer roomOffsetX;
    private Integer roomOffsetY;
    private Boolean isRotationRandom;
    private Float zAngleRotation;
    private Integer spawnRadius;
    private Integer spawnTryCount;
    private Integer icon;
}
