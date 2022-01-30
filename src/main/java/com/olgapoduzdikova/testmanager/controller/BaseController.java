package com.olgapoduzdikova.testmanager.controller;

import org.modelmapper.ModelMapper;

public abstract class BaseController<E, DTO> {

    private final ModelMapper mapper;

    protected BaseController(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public abstract Class<E> getEntityType();

    public abstract Class<DTO> getDtoType();

    protected DTO convertToDto(E entity) {
        return mapper.map(entity, getDtoType());
    }

    protected E convertToEntity(DTO dto) {
        return mapper.map(dto, getEntityType());
    }
}
