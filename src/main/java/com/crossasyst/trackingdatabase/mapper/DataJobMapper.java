package com.crossasyst.trackingdatabase.mapper;

import com.crossasyst.trackingdatabase.entity.DataJobEntity;
import com.crossasyst.trackingdatabase.model.DataJob;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DataJobMapper {

    @Mapping(source = "dataChannel", target = "dataChannelEntity")
    @Mapping(source = "jobStatusType", target = "jobStatusTypeEntity")
    DataJobEntity modelToEntity(DataJob dataJob);

}
