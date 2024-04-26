package com.badassuniverse.mapstoragebackend.mapper.impl;

import com.badassuniverse.mapstoragebackend.dto.MobDto;
import com.badassuniverse.mapstoragebackend.mapper.MobListMapper;
import com.badassuniverse.mapstoragebackend.mapper.MobMapper;
import com.badassuniverse.mapstoragebackend.model.Mob;
import com.badassuniverse.mapstoragebackend.model.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MobListMapperImpl implements MobListMapper {
    private final MobMapper mobMapper;

    public List<Mob> toModelList(List<MobDto> dloList, Room room) {
        if (dloList == null) {
            return null;
        } else {
            List<Mob> list = new ArrayList<>(dloList.size());
            for (MobDto mobDto : dloList) {
                list.add(this.mobMapper.toModel(mobDto, room));
            }
            return list;
        }
    }

    public List<MobDto> toDTOList(List<Mob> modelList) {
        if (modelList == null) {
            return null;
        } else {
            List<MobDto> list = new ArrayList<>(modelList.size());
            for (Mob mob : modelList) {
                list.add(this.mobMapper.toDTO(mob));
            }
            return list;
        }
    }
}
