package com.badassuniverse.mapstoragebackend.mapper.impl;

import com.badassuniverse.mapstoragebackend.dto.PhysicsItemDto;
import com.badassuniverse.mapstoragebackend.mapper.PhysicsItemListMapper;
import com.badassuniverse.mapstoragebackend.mapper.PhysicsItemMapper;
import com.badassuniverse.mapstoragebackend.model.PhysicsItem;
import com.badassuniverse.mapstoragebackend.model.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PhysicsItemListMapperImpl implements PhysicsItemListMapper {
    private final PhysicsItemMapper physicsItemMapper;

    public List<PhysicsItem> toModelList(List<PhysicsItemDto> dloList, Room room) {
        if (dloList == null) {
            return null;
        } else {
            List<PhysicsItem> list = new ArrayList<>(dloList.size());
            for (PhysicsItemDto physicsItemDto : dloList) {
                list.add(this.physicsItemMapper.toModel(physicsItemDto, room));
            }
            return list;
        }
    }

    public List<PhysicsItemDto> toDTOList(List<PhysicsItem> modelList) {
        if (modelList == null) {
            return null;
        } else {
            List<PhysicsItemDto> list = new ArrayList<>(modelList.size());
            for (PhysicsItem physicsItem : modelList) {
                list.add(this.physicsItemMapper.toDTO(physicsItem));
            }
            return list;
        }
    }
}
