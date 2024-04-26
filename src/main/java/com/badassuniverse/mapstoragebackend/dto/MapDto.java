package com.badassuniverse.mapstoragebackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class MapDto {
    private String name;

    @JsonProperty("xLength")
    private Integer xLength;

    @JsonProperty("yLength")
    private Integer yLength;

    private Integer userId;
    private Integer playerSpawnRoomId;
    private String version;
    private List<FacadeDto> facades;
    private List<RoomDto> rooms;
}
