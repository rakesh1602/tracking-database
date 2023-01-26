package com.crossasyst.trackingdatabase.mapper;

import com.crossasyst.trackingdatabase.entity.ObjectRefEntity;
import com.crossasyst.trackingdatabase.model.ObjectRef;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ObjectRefMapper {

    @Mapping(source = "nodeType", target = "nodeTypeEntity")
    @Mapping(source = "message", target = "messageEntity")
    ObjectRefEntity modelToEntity(ObjectRef objectRef);

    @Mapping(source = "nodeTypeEntity", target = "nodeType")
    @Mapping(source = "messageEntity", target = "message")
    ObjectRef entityToModel(ObjectRefEntity objectRefEntity);
}
