package com.badassuniverse.mapstoragebackend.mapper.impl;

import com.badassuniverse.mapstoragebackend.dtos.FacadeDto;
import com.badassuniverse.mapstoragebackend.mapper.FacadeListMapper;
import com.badassuniverse.mapstoragebackend.mapper.FacadeMapper;
import com.badassuniverse.mapstoragebackend.model.Facade;
import com.badassuniverse.mapstoragebackend.model.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FacadeListMapperImpl implements FacadeListMapper {
    private final FacadeMapper facadeMapper;

    public List<Facade> toModelList(List<FacadeDto> dtoList, Map map) {
        if (dtoList == null) {
            return null;
        } else {
            List<Facade> list = new ArrayList<>(dtoList.size());
            for (FacadeDto facadeDto : dtoList) {
                list.add(this.facadeMapper.toModel(facadeDto, map));
            }
            return list;
        }
    }

    public List<FacadeDto> toDTOList(List<Facade> modelList) {
        if (modelList == null) {
            return null;
        } else {
            List<FacadeDto> list = new ArrayList<>(modelList.size());
            for (Facade facade : modelList) {
                list.add(this.facadeMapper.toDTO(facade));
            }
            return list;
        }
    }
}
