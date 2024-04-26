package com.badassuniverse.mapstoragebackend.mapper;

import com.badassuniverse.mapstoragebackend.dto.MobDto;
import com.badassuniverse.mapstoragebackend.model.Mob;
import com.badassuniverse.mapstoragebackend.model.Room;

import java.util.List;

public interface MobListMapper {
    List<Mob> toModelList(List<MobDto> dtoList, Room room);
    List<MobDto> toDTOList(List<Mob> modelList);
}
