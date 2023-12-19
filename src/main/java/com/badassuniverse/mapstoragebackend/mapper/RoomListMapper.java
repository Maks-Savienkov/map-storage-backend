package com.badassuniverse.mapstoragebackend.mapper;

import com.badassuniverse.mapstoragebackend.dtos.RoomDto;
import com.badassuniverse.mapstoragebackend.model.Map;
import com.badassuniverse.mapstoragebackend.model.Room;

import java.util.List;

public interface RoomListMapper {
    List<Room> toModelList(List<RoomDto> dloList, Map map);
    List<RoomDto> toDTOList(List<Room> modelList);
}
