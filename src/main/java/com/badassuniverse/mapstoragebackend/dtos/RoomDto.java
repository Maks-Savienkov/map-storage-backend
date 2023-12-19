package com.badassuniverse.mapstoragebackend.dtos;

import com.badassuniverse.mapstoragebackend.model.Color;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RoomDto {
    private Integer id;
    private String name;
    private Integer inGameRoomId;
    private Integer mapOffsetX;
    private Integer mapOffsetY;
    private String params;
    private String doorParams;
    private Integer floor;
    private String rotation;
    private Color color;
    private List<PhysicsItemDto> physicsItems;
    private List<MobDto> mobs;
}
