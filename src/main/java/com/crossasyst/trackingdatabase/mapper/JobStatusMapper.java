package com.crossasyst.trackingdatabase.mapper;

import com.crossasyst.trackingdatabase.entity.JobStatusTypeEntity;
import com.crossasyst.trackingdatabase.model.JobStatusType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobStatusMapper {

    JobStatusType entityToModel(JobStatusTypeEntity jobStatusTypeEntity);
}
