package com.badassuniverse.mapstoragebackend.model;

import com.badassuniverse.mapstoragebackend.converter.ColorConverter;
import jakarta.persistence.*;
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
@Table(name = "physics_items")
public class PhysicsItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Convert(converter = ColorConverter.class)
    private Color color;

    private Integer inGamePhysicsItemId;
    private Boolean simulatePhysics;
    private Integer roomOffsetX;
    private Integer roomOffsetY;
    private Boolean isRotationRandom;
    private Float zAngleRotation;
    private Integer spawnRadius;
    private Integer spawnTryCount;
    private Integer icon;
}
