package com.badassuniverse.mapstoragebackend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MapDto {
    private String name;

    @JsonProperty("xLength")
    private Integer xLength;

    @JsonProperty("yLength")
    private Integer yLength;

    private Integer playerSpawnRoomId;
    private String version;
    private List<FacadeDto> facades;
    private List<RoomDto> rooms;
}
