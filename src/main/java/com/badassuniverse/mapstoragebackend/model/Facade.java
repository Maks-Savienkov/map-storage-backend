package com.badassuniverse.mapstoragebackend.model;

import com.badassuniverse.mapstoragebackend.converter.ColorConverter;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "facades")
public class Facade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Nullable
    private String name;

    @Convert(converter = ColorConverter.class)
    private Color color;

    private Integer inGameFacadeId;
    private Integer mapOffsetX;
    private Integer mapOffsetY;
    private Integer floor;
    private Direction rotation;
}
