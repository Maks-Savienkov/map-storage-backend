package com.badassuniverse.mapstoragebackend.dto;

import com.badassuniverse.mapstoragebackend.model.Color;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FacadeDto {
    private Integer id;
    private String name;
    private Integer inGameFacadeId;
    private Integer mapOffsetX;
    private Integer mapOffsetY;
    private Integer floor;
    private String rotation;
    private Color color;
}
