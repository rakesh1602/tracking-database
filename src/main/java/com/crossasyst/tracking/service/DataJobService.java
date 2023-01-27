package com.crossasyst.tracking.service;

import com.crossasyst.tracking.entity.DataChannelEntity;
import com.crossasyst.tracking.entity.DataJobEntity;
import com.crossasyst.tracking.entity.JobStatusTypeEntity;
import com.crossasyst.tracking.mapper.DataJobMapper;
import com.crossasyst.tracking.model.DataJob;
import com.crossasyst.tracking.repository.DataJobRepository;
import com.crossasyst.tracking.response.DataJobResponse;
import com.crossasyst.tracking.utils.Constants;
import com.crossasyst.tracking.utils.UUIDGenerator;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class DataJobService {

    private final DataJobRepository dataJobRepository;

    private final DataJobMapper dataJobMapper;

    private final UUIDGenerator uuidGenerator=new UUIDGenerator();

    @Autowired
    public DataJobService(DataJobRepository dataJobRepository, DataJobMapper dataJobMapper) {
        this.dataJobRepository = dataJobRepository;
        this.dataJobMapper = dataJobMapper;
    }

    /**
     * @author Rakesh Chavan, Sanket Mishra
     */
    public DataJobResponse createJob(DataJob dataJob) {

        log.info("Adding data job.");

        DataJobEntity dataJobEntity = dataJobMapper.modelToEntity(dataJob);
        dataJobEntity.setDataJobGUID(uuidGenerator.generateUUID());
        dataJobEntity.setOrgUuid(uuidGenerator.generateUUID());
        dataJobRepository.save(dataJobEntity);
        log.info("Data job details saved successfully.");

        DataJobResponse dataJobResponse = new DataJobResponse();
        dataJobResponse.setDataJobID(dataJobEntity.getDataJobId());
        dataJobResponse.setDataJobGuid(dataJobEntity.getDataJobGUID());
        log.info("Data job id {} ", dataJobResponse.getDataJobID());

        return dataJobResponse;
    }

    /**
     * @author Rushi Kandekar,Raj Bokade
     */
    public DataJob updateJob(String dataJobGuid, DataJob dataJob) {

        log.info("Retrieving data job of data job guid {}. ", dataJobGuid);

        DataJobEntity dataJobEntity = dataJobRepository.findByDataJobGuid(dataJobGuid)
                .orElseThrow(() -> new IllegalArgumentException(Constants.DATA_JOB_GUID_NOT_FOUND));

        Long dataJobId = dataJobEntity.getDataJobId();

        DataChannelEntity dataChannelEntity = dataJobEntity.getDataChannelEntity();
        String dataChannelCd = dataChannelEntity.getDataChannelCd();

        JobStatusTypeEntity jobStatusTypeEntity = dataJobEntity.getJobStatusTypeEntity();
        String jobStatusTypeCd = jobStatusTypeEntity.getJobStatusType();

        String exDataJobGuid=dataJobEntity.getDataJobGUID();

        log.info("Updating data job entity of data job guid {}. ", dataJobGuid);

        DataJobEntity newDataJobEntity = dataJobMapper.modelToEntity(dataJob);
        newDataJobEntity.setDataJobId(dataJobId);
        newDataJobEntity.getDataChannelEntity().setDataChannelCd(dataChannelCd);
        newDataJobEntity.getJobStatusTypeEntity().setJobStatusType(jobStatusTypeCd);
        newDataJobEntity.setDataJobGUID(exDataJobGuid);
        dataJobRepository.save(newDataJobEntity);

        log.info("Data job updated of  data job guid {} updated.", dataJobGuid);

        return dataJob;
    }
}
