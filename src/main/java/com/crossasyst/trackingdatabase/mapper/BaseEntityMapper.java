package com.crossasyst.trackingdatabase.mapper;

import com.crossasyst.trackingdatabase.entity.base.BaseEntity;
import com.crossasyst.trackingdatabase.model.base.Base;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BaseEntityMapper {

    BaseEntity modelToEntity(Base base);
}
