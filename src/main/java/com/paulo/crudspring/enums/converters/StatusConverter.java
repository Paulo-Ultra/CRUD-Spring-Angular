package com.paulo.crudspring.enums.converters;

import com.paulo.crudspring.enums.StatusEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<StatusEnum, String> {

    @Override
    public String convertToDatabaseColumn(StatusEnum statusEnum) {
        if(statusEnum == null) {
            return null;
        }
        return statusEnum.getValue();
    }

    @Override
    public StatusEnum convertToEntityAttribute(String value) {
        if(value == null){
            return null;
        }
        return Stream.of(StatusEnum.values())
                .filter(c -> c.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }
}
