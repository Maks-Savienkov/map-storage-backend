package com.badassuniverse.mapstoragebackend.mapper.impl;

import com.badassuniverse.mapstoragebackend.dtos.RoomDto;
import com.badassuniverse.mapstoragebackend.mapper.RoomListMapper;
import com.badassuniverse.mapstoragebackend.mapper.RoomMapper;
import com.badassuniverse.mapstoragebackend.model.Map;
import com.badassuniverse.mapstoragebackend.model.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RoomListMapperImpl implements RoomListMapper {
    private final RoomMapper roomMapper;

    public List<Room> toModelList(List<RoomDto> dtoList, Map map) {
        if (dtoList == null) {
            return null;
        } else {
            List<Room> list = new ArrayList<>(dtoList.size());
            for (RoomDto roomDto : dtoList) {
                list.add(this.roomMapper.toModel(roomDto, map));
            }
            return list;
        }
    }

    public List<RoomDto> toDTOList(List<Room> modelList) {
        if (modelList == null) {
            return null;
        } else {
            List<RoomDto> list = new ArrayList<>(modelList.size());
            for (Room room : modelList) {
                list.add(roomMapper.toDTO(room));
            }
            return list;
        }
    }
}
