package com.badassuniverse.mapstoragebackend.mapper;

import com.badassuniverse.mapstoragebackend.dtos.PhysicsItemDto;
import com.badassuniverse.mapstoragebackend.model.PhysicsItem;
import com.badassuniverse.mapstoragebackend.model.Room;

import java.util.List;

public interface PhysicsItemListMapper {
    List<PhysicsItem> toModelList(List<PhysicsItemDto> dloList, Room room);
    List<PhysicsItemDto> toDTOList(List<PhysicsItem> modelList);
}
