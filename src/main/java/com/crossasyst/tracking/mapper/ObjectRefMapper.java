package com.crossasyst.tracking.mapper;

import com.crossasyst.tracking.entity.ObjectRefEntity;
import com.crossasyst.tracking.model.ObjectRef;
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
