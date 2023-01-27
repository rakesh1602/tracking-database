package com.crossasyst.tracking.mapper;

import com.crossasyst.tracking.entity.JobStatusTypeEntity;
import com.crossasyst.tracking.model.JobStatusType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobStatusMapper {

    JobStatusType entityToModel(JobStatusTypeEntity jobStatusTypeEntity);
}
