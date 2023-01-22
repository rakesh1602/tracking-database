package com.crossasyst.trackingdatabase.mapper;

import com.crossasyst.trackingdatabase.entity.DataJobEntity;
import com.crossasyst.trackingdatabase.model.DataJob;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataJobMapper {

    DataJobEntity modelToEntity(DataJob dataJob);
    DataJob entityToModel(DataJobEntity dataJobEntity);
}
