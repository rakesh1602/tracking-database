package com.crossasyst.tracking.service;

import com.crossasyst.tracking.entity.JobStatusTypeEntity;
import com.crossasyst.tracking.mapper.JobStatusMapper;
import com.crossasyst.tracking.model.JobStatusType;
import com.crossasyst.tracking.repository.DataJobRepository;
import com.crossasyst.tracking.utils.Constants;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class JobStatusService {

    private final DataJobRepository dataJobRepository;

    private final JobStatusMapper jobStatusMapper;

    private JobStatusType jobStatusType;

    @Autowired
    public JobStatusService(DataJobRepository dataJobRepository, JobStatusMapper jobStatusMapper) {
        this.dataJobRepository = dataJobRepository;
        this.jobStatusMapper = jobStatusMapper;
    }

    /**
     * @author Adika Dome, Vishal Pandey
     */
    public JobStatusType getJobStatus(String dataJobGuid) {

        log.info("Retrieving job status of data job guid {}. ", dataJobGuid);

        Optional<JobStatusTypeEntity> jobStatusTypeEntity = Optional.ofNullable(Optional.ofNullable(dataJobRepository.findByDataJobGuid(dataJobGuid).get().getJobStatusTypeEntity())
                .orElseThrow(() -> new IllegalArgumentException(Constants.DATA_JOB_GUID_NOT_FOUND)));

        jobStatusTypeEntity.ifPresent(statusTypeEntity -> jobStatusType = jobStatusMapper.entityToModel(statusTypeEntity));

        return jobStatusType;
    }
}
