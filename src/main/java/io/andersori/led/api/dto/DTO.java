package io.andersori.led.api.dto;

import org.modelmapper.ModelMapper;

public abstract class DTO<Source, Destination> {

    private Class<Source> sourceType;
    private Class<Destination> destinationType;

    public DTO(Class<Source> sourceType, Class<Destination> destinationType){
        this.sourceType = sourceType;
        this.destinationType = destinationType;
    }

    public Destination toDto(Source entity) {
        return new ModelMapper().map(entity, destinationType);
    }

    public Source toEntity(Destination dto) {
        return new ModelMapper().map(dto, sourceType);
    }
}