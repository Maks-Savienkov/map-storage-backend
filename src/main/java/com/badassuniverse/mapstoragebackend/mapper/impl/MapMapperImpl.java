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
            return MapDto.builder()
                    .name(model.getName())
                    .playerSpawnRoomId(model.getPlayerSpawnRoomId())
                    .version(model.getVersion())
                    .facades(facadeListMapper.toDTOList(model.getFacades()))
                    .rooms(roomListMapper.toDTOList(model.getRooms()))
                    .xLength(model.getXLength())
                    .yLength(model.getYLength())
                    .userId(model.getUser().getId())
                    .build();
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
