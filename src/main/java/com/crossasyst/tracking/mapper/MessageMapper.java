package com.crossasyst.tracking.mapper;

import com.crossasyst.tracking.entity.MessageEntity;
import com.crossasyst.tracking.model.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    @Mapping(source = "processingStatusType", target = "processingStatusTypeEntity")
    @Mapping(source = "processingStatusType.messageList", target = "processingStatusTypeEntity.messageEntity", ignore = true)
    MessageEntity modelToEntity(Message message);
}
