package com.badassuniverse.mapstoragebackend.dto;

import com.badassuniverse.mapstoragebackend.model.Color;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MobDto {
    private Integer id;
    private String name;
    private Integer inGameMobId;
    private Integer roomOffsetX;
    private Integer roomOffsetY;
    private Boolean isRotationRandom;
    @JsonProperty("zAngleRotation")
    private Float zAngleRotation;
    private Integer spawnRadius;
    private Integer spawnTryCount;
    private Integer icon;
    private Color color;
    private Integer roomId;
}
