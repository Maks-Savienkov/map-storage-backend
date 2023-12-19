package com.badassuniverse.mapstoragebackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "maps")
public class Map {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @JsonProperty("xLength")
    private Integer xLength;

    @JsonProperty("yLength")
    private Integer yLength;

    private Integer playerSpawnRoomId;
    private String version;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "map", cascade = CascadeType.ALL)
    private List<Facade> facades;

    @OneToMany(mappedBy = "map", cascade = CascadeType.ALL)
    private List<Room> rooms;
}
