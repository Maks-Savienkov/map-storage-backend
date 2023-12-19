package com.badassuniverse.mapstoragebackend.mapper.impl;

import com.badassuniverse.mapstoragebackend.dtos.RoomDto;
import com.badassuniverse.mapstoragebackend.mapper.MobListMapper;
import com.badassuniverse.mapstoragebackend.mapper.PhysicsItemListMapper;
import com.badassuniverse.mapstoragebackend.mapper.RoomMapper;
import com.badassuniverse.mapstoragebackend.model.Direction;
import com.badassuniverse.mapstoragebackend.model.Map;
import com.badassuniverse.mapstoragebackend.model.Room;
import com.badassuniverse.mapstoragebackend.repo.MapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoomMapperImpl implements RoomMapper {
    private final PhysicsItemListMapper physicsItemListMapper;
    private final MobListMapper mobListMapper;

    public RoomDto toDTO(Room model) {
        if (model == null) {
            return null;
        } else {
            return RoomDto.builder()
                    .id(model.getId())
                    .name(model.getName())
                    .inGameRoomId(model.getInGameRoomId())
                    .mapOffsetX(model.getMapOffsetX())
                    .mapOffsetY(model.getMapOffsetY())
                    .params(model.getParams())
                    .doorParams(model.getDoorParams())
                    .floor(model.getFloor())
                    .rotation(model.getRotation().name())
                    .color(model.getColor())
                    .physicsItems(physicsItemListMapper.toDTOList(model.getPhysicsItems()))
                    .mobs(mobListMapper.toDTOList(model.getMobs()))
                    .build();
        }
    }

    public Room toModel(RoomDto dto, Map map) {
        if (dto == null) {
            return null;
        } else {
            Room room = Room.builder()
                    .map(map)
                    .name(dto.getName())
                    .inGameRoomId(dto.getInGameRoomId())
                    .mapOffsetX(dto.getMapOffsetX())
                    .mapOffsetY(dto.getMapOffsetY())
                    .params(dto.getParams())
                    .doorParams(dto.getDoorParams())
                    .floor(dto.getFloor())
                    .rotation(Direction.valueOf(dto.getRotation()))
                    .color(dto.getColor())
                    .build();

            room.setPhysicsItems(physicsItemListMapper.toModelList(dto.getPhysicsItems(), room));
            room.setMobs(mobListMapper.toModelList(dto.getMobs(), room));

            return room;
        }
    }
}
