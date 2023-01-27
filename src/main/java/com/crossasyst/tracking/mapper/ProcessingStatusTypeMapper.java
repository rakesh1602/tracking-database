package com.crossasyst.tracking.mapper;

import com.crossasyst.tracking.entity.ProcessingStatusTypeEntity;
import com.crossasyst.tracking.model.ProcessingStatusType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProcessingStatusTypeMapper {

    @Mapping(source = "messageEntity", target = "messageList")
    ProcessingStatusType entityToModel(ProcessingStatusTypeEntity processingStatusTypeEntity);
}
