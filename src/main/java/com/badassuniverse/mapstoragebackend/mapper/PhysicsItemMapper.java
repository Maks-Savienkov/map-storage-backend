package com.badassuniverse.mapstoragebackend.mapper;

import com.badassuniverse.mapstoragebackend.dto.PhysicsItemDto;
import com.badassuniverse.mapstoragebackend.model.PhysicsItem;
import com.badassuniverse.mapstoragebackend.model.Room;

public interface PhysicsItemMapper {
    PhysicsItemDto toDTO(PhysicsItem model);

    PhysicsItem toModel(PhysicsItemDto dto, Room room);
}
