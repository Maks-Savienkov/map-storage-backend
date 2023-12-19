package com.badassuniverse.mapstoragebackend.converter;

import com.badassuniverse.mapstoragebackend.model.Color;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ColorConverter implements AttributeConverter<Color, byte[]> {

    @Override
    public byte[] convertToDatabaseColumn(Color color) {
        try {
            if (color == null) {
                return null;
            }
            byte[] bytes = new byte[3];
            bytes[0] = color.getRed().byteValue();
            bytes[1] = color.getGreen().byteValue();
            bytes[2] = color.getBlue().byteValue();
            return bytes;
        } catch (Exception e) {
            throw new RuntimeException("Error converting Color to bytes", e);
        }
    }

    @Override
    public Color convertToEntityAttribute(byte[] bytes) {
        try {
            if (bytes == null || bytes.length != 3) {
                return null;
            }
            return new Color(bytes[0] & 0xFF, bytes[1] & 0xFF, bytes[2] & 0xFF);
        } catch (Exception e) {
            throw new RuntimeException("Error converting bytes to Color", e);
        }
    }
}
