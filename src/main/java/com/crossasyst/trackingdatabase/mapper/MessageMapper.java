package com.crossasyst.trackingdatabase.mapper;

import com.crossasyst.trackingdatabase.entity.MessageEntity;
import com.crossasyst.trackingdatabase.model.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    @Mapping(source = "processingStatusType", target = "processingStatusTypeEntity")
    @Mapping(source = "processingStatusType.messageList", target = "processingStatusTypeEntity.messageEntity", ignore = true)
    MessageEntity modelToEntity(Message message);
}
