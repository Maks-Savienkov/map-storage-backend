package com.badassuniverse.mapstoragebackend.mapper.impl;

import com.badassuniverse.mapstoragebackend.dto.MapDto;
import com.badassuniverse.mapstoragebackend.mapper.FacadeListMapper;
import com.badassuniverse.mapstoragebackend.mapper.MapMapper;
import com.badassuniverse.mapstoragebackend.mapper.RoomListMapper;
import com.badassuniverse.mapstoragebackend.model.Map;
import com.badassuniverse.mapstoragebackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MapMapperImpl implements MapMapper {
    private final UserService userService;
    private final FacadeListMapper facadeListMapper;
    private final RoomListMapper roomListMapper;

    public MapDto toDTO(Map model) {
        if (model == null) {
            return null;
        } else {
            String name = model.getName();
            Integer playerSpawnRoomId = model.getPlayerSpawnRoomId();
            String version = model.getVersion();
            List<FacadeDto> facades = facadeListMapper.toDTOList(model.getFacades());
            List<RoomDto> rooms = roomListMapper.toDTOList(model.getRooms());
            Integer xLength = model.getXLength();
            Integer yLength = model.getYLength();
            Integer userId = model.getUser().getId();
            return new MapDto(name, xLength, yLength, userId, playerSpawnRoomId, version, facades, rooms);
        }
    }

    public Map toModel(MapDto dto) {
        if (dto == null) {
            return null;
        } else {
            Map map = Map.builder()
                    .name(dto.getName())
                    .xLength(dto.getXLength())
                    .yLength(dto.getYLength())
                    .playerSpawnRoomId(dto.getPlayerSpawnRoomId())
                    .version(dto.getVersion())
                    .build();

            String name = SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getName();
            map.setUser(
                    userService.findByUsername(
                            name
                    ).get()
            );
            map.setFacades(facadeListMapper.toModelList(dto.getFacades(), map));
            map.setRooms(roomListMapper.toModelList(dto.getRooms(), map));

            return map;
        }
    }
}
