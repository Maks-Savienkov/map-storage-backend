package com.badassuniverse.mapstoragebackend.mapper.impl;

import com.badassuniverse.mapstoragebackend.dtos.MobDto;
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
            MobDto mobDto = new MobDto();
            mobDto.setId(mobDto.getId());
            mobDto.setName(model.getName());
            mobDto.setInGameMobId(model.getInGameMobId());
            mobDto.setRoomOffsetX(model.getRoomOffsetX());
            mobDto.setRoomOffsetY(model.getRoomOffsetY());
            mobDto.setIsRotationRandom(model.getIsRotationRandom());
            mobDto.setZAngleRotation(model.getZAngleRotation());
            mobDto.setSpawnRadius(model.getSpawnRadius());
            mobDto.setSpawnTryCount(model.getSpawnTryCount());
            mobDto.setIcon(model.getIcon());
            //mobDto.setRoomId(model.getRoom().getId());
            mobDto.setColor(model.getColor());
            return mobDto;
        }
    }

    public Mob toModel(MobDto dto, Room room) {
        if (dto == null) {
            return null;
        } else {
            return Mob.builder()
                    //.room(room)
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
