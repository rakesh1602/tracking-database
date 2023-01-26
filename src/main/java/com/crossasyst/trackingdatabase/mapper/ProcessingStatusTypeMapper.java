package com.crossasyst.trackingdatabase.mapper;

import com.crossasyst.trackingdatabase.entity.ProcessingStatusTypeEntity;
import com.crossasyst.trackingdatabase.model.ProcessingStatusType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProcessingStatusTypeMapper {

    @Mapping(source = "messageEntity", target = "messageList")
    ProcessingStatusType entityToModel(ProcessingStatusTypeEntity processingStatusTypeEntity);
}
