package com.badassuniverse.mapstoragebackend.model;

import com.badassuniverse.mapstoragebackend.converter.ColorConverter;
import jakarta.annotation.Nullable;
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
@Embeddable
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="map_id", nullable=false)
    private Map map;

    @Nullable
    private String name;

    private Integer inGameRoomId;
    private Integer mapOffsetX;
    private Integer mapOffsetY;
    private String params; // json
    private String doorParams; // json
    private Integer floor;
    private Direction rotation;

    @Convert(converter = ColorConverter.class)
    private Color color;

    @OneToMany(mappedBy="room", cascade = CascadeType.ALL)
    private List<PhysicsItem> physicsItems;

    @OneToMany(mappedBy="room", cascade = CascadeType.ALL)
    private List<Mob> mobs;
}
