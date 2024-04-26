package com.badassuniverse.mapstoragebackend.mapper;

import com.badassuniverse.mapstoragebackend.dto.MobDto;
import com.badassuniverse.mapstoragebackend.model.Mob;
import com.badassuniverse.mapstoragebackend.model.Room;

public interface MobMapper {
    MobDto toDTO(Mob model);

    Mob toModel(MobDto dto, Room room);
}
