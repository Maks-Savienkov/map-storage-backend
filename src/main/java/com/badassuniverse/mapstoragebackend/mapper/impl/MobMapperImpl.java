package com.badassuniverse.mapstoragebackend.mapper.impl;

import com.badassuniverse.mapstoragebackend.dto.MobDto;
import com.badassuniverse.mapstoragebackend.mapper.MobMapper;
import com.badassuniverse.mapstoragebackend.model.Mob;
import com.badassuniverse.mapstoragebackend.model.Room;
import org.springframework.stereotype.Component;

@Component
public class MobMapperImpl implements MobMapper {
    public MobDto toDTO(Mob model) {
        if (model == null) {
            return null;
        } else {
            return MobDto.builder()
                    .id(model.getId())
                    .roomId(model.getRoom().getId())
                    .name(model.getName())
                    .inGameMobId(model.getInGameMobId())
                    .roomOffsetX(model.getRoomOffsetX())
                    .roomOffsetY(model.getRoomOffsetY())
                    .isRotationRandom(model.getIsRotationRandom())
                    .zAngleRotation(model.getZAngleRotation())
                    .spawnRadius(model.getSpawnRadius())
                    .spawnTryCount(model.getSpawnTryCount())
                    .icon(model.getIcon())
                    .color(model.getColor())
                    .build();
        }
    }

    public Mob toModel(MobDto dto, Room room) {
        if (dto == null) {
            return null;
        } else {
            return Mob.builder()
                    .room(room)
                    .name(dto.getName())
                    .inGameMobId(dto.getInGameMobId())
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
