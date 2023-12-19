package com.badassuniverse.mapstoragebackend.mapper.impl;

import com.badassuniverse.mapstoragebackend.dtos.PhysicsItemDto;
import com.badassuniverse.mapstoragebackend.mapper.PhysicsItemMapper;
import com.badassuniverse.mapstoragebackend.model.PhysicsItem;
import com.badassuniverse.mapstoragebackend.model.Room;
import org.springframework.stereotype.Component;

@Component
public class PhysicsItemMapperImpl implements PhysicsItemMapper {

    public PhysicsItemDto toDTO(PhysicsItem model) {
        if (model == null) {
            return null;
        } else {
            return PhysicsItemDto.builder()
                    .id(model.getId())
                    .inGamePhysicsItemId(model.getInGamePhysicsItemId())
                    .simulatePhysics(model.getSimulatePhysics())
                    .roomOffsetX(model.getRoomOffsetX())
                    .roomOffsetY(model.getRoomOffsetY())
                    .isRotationRandom(model.getIsRotationRandom())
                    .zAngleRotation(model.getZAngleRotation())
                    .spawnRadius(model.getSpawnRadius())
                    .spawnTryCount(model.getSpawnTryCount())
                    .icon(model.getIcon())
                    .color(model.getColor())
                    //.roomId(model.getRoom().getId())
                    .build();
        }
    }

    public PhysicsItem toModel(PhysicsItemDto dto, Room room) {
        if (dto == null) {
            return null;
        } else {
            return PhysicsItem.builder()
                    //.room(room)
                    .inGamePhysicsItemId(dto.getInGamePhysicsItemId())
                    .simulatePhysics(dto.getSimulatePhysics())
                    .roomOffsetX(dto.getRoomOffsetX())
                    .roomOffsetY(dto.getRoomOffsetY())
                    .isRotationRandom(dto.getIsRotationRandom())
                    .zAngleRotation(dto.getZAngleRotation())
                    .spawnRadius(dto.getSpawnRadius())
                    .spawnTryCount(dto.getSpawnTryCount())
                    .icon(dto.getIcon())
                    .color(dto.getColor())
                    .build();
        }
    }
}
