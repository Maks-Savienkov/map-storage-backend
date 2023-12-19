package com.badassuniverse.mapstoragebackend.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Color implements Serializable {
    private Integer red;
    private Integer green;
    private Integer blue;

    public Color(byte red, byte green, byte blue) {
        this.red = Byte.toUnsignedInt(red);
        this.green = Byte.toUnsignedInt(green);
        this.blue = Byte.toUnsignedInt(blue);
    }
}
