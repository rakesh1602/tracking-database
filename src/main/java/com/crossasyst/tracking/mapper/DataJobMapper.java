package com.crossasyst.tracking.mapper;

import com.crossasyst.tracking.entity.DataJobEntity;
import com.crossasyst.tracking.model.DataJob;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DataJobMapper {

    @Mapping(source = "dataChannel", target = "dataChannelEntity")
    @Mapping(source = "jobStatusType", target = "jobStatusTypeEntity")
    DataJobEntity modelToEntity(DataJob dataJob);

}
