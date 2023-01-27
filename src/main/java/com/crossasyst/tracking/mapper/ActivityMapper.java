package com.crossasyst.tracking.mapper;

import com.crossasyst.tracking.entity.ActivityEntity;
import com.crossasyst.tracking.model.Activity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ActivityMapper {

    @Mapping(source = "message", target = "messageEntity")
    @Mapping(source = "activityType", target = "activityTypeEntity")
    @Mapping(source = "processingStatusType", target = "processingStatusTypeEntity")
    ActivityEntity modelToEntity(Activity activity);

    @Mapping(target = "message", source = "messageEntity")
    @Mapping(target = "activityType", source = "activityTypeEntity")
    @Mapping(target = "processingStatusType", source = "processingStatusTypeEntity")
    Activity entityToModel(ActivityEntity activityEntity);
}
