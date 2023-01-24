package com.crossasyst.trackingdatabase.service;

import com.crossasyst.trackingdatabase.entity.DataJobEntity;
import com.crossasyst.trackingdatabase.mapper.DataJobMapper;
import com.crossasyst.trackingdatabase.model.DataJob;
import com.crossasyst.trackingdatabase.repository.DataJobRepository;
import com.crossasyst.trackingdatabase.response.DataJobResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class DataJobService {

    private final DataJobRepository dataJobRepository;

    private final DataJobMapper dataJobMapper;

    @Autowired
    public DataJobService(DataJobRepository dataJobRepository, DataJobMapper dataJobMapper) {
        this.dataJobRepository = dataJobRepository;
        this.dataJobMapper = dataJobMapper;
    }

    public DataJobResponse createJob(DataJob dataJob) {

        log.info("Create data job.");

        DataJobEntity dataJobEntity = dataJobMapper.modelToEntity(dataJob);
        dataJobRepository.save(dataJobEntity);
        log.info("Data job details saved successfully.");

        DataJobResponse dataJobResponse = new DataJobResponse();
        dataJobResponse.setDataJobID(dataJobEntity.getDataJobId());
        dataJobResponse.setDataJobGUID(dataJobEntity.getDataJobGUID());

        return dataJobResponse;
    }
}
