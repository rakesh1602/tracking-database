package com.crossasyst.trackingdatabase.service;

import com.crossasyst.trackingdatabase.entity.JobStatusTypeEntity;
import com.crossasyst.trackingdatabase.mapper.JobStatusMapper;
import com.crossasyst.trackingdatabase.model.JobStatusType;
import com.crossasyst.trackingdatabase.repository.DataJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobStatusService {

    private final DataJobRepository dataJobRepository;

    private final JobStatusMapper jobStatusMapper;

    @Autowired
    public JobStatusService(DataJobRepository dataJobRepository, JobStatusMapper jobStatusMapper) {
        this.dataJobRepository = dataJobRepository;
        this.jobStatusMapper = jobStatusMapper;
    }

    public JobStatusType getJobStatus(String datajobGuid) {

        JobStatusTypeEntity jobStatusTypeEntity= dataJobRepository.findByDataJobGuid(datajobGuid).getJobStatusTypeEntity();

       JobStatusType jobStatusType=new JobStatusType();
       jobStatusType=jobStatusMapper.entityToModel(jobStatusTypeEntity);
       return jobStatusType;


    }
}
