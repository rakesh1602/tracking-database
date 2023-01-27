package com.crossasyst.tracking.mapper;

import com.crossasyst.tracking.entity.base.BaseEntity;
import com.crossasyst.tracking.model.base.Base;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BaseEntityMapper {

    BaseEntity modelToEntity(Base base);
}
