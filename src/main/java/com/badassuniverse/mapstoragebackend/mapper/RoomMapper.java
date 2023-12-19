package com.badassuniverse.mapstoragebackend.mapper;

import com.badassuniverse.mapstoragebackend.dtos.RoomDto;
import com.badassuniverse.mapstoragebackend.model.Map;
import com.badassuniverse.mapstoragebackend.model.Room;

public interface RoomMapper {
    RoomDto toDTO(Room model);

    Room toModel(RoomDto dto, Map map);
}
