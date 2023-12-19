package com.badassuniverse.mapstoragebackend.dtos;

import com.badassuniverse.mapstoragebackend.model.Color;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhysicsItemDto {
    private Integer id;
    private Integer inGamePhysicsItemId;
    private Boolean simulatePhysics;
    private Integer roomOffsetX;
    private Integer roomOffsetY;
    private Boolean isRotationRandom;
    private Float zAngleRotation;
    private Integer spawnRadius;
    private Integer spawnTryCount;
    private Integer icon;
    private Color color;
    private Integer roomId;
}
