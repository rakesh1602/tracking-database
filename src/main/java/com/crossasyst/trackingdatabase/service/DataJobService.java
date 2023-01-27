package com.crossasyst.trackingdatabase.service;

import com.crossasyst.trackingdatabase.entity.DataChannelEntity;
import com.crossasyst.trackingdatabase.entity.DataJobEntity;
import com.crossasyst.trackingdatabase.entity.JobStatusTypeEntity;
import com.crossasyst.trackingdatabase.mapper.DataJobMapper;
import com.crossasyst.trackingdatabase.model.DataJob;
import com.crossasyst.trackingdatabase.repository.DataJobRepository;
import com.crossasyst.trackingdatabase.response.DataJobResponse;
import com.crossasyst.trackingdatabase.utils.Constants;
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

    /**
     * @author Rakesh Chavan, Sanket Mishra
     */
    public DataJobResponse createJob(DataJob dataJob) {

        log.info("Adding data job.");

        DataJobEntity dataJobEntity = dataJobMapper.modelToEntity(dataJob);
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
    public DataJob updateJob(String datajobGuid, DataJob dataJob) {

        log.info("Retrieving data job of data job guid {}. ", datajobGuid);

        DataJobEntity dataJobEntity = dataJobRepository.findByDataJobGuid(datajobGuid)
                .orElseThrow(() -> new IllegalArgumentException(Constants.DATA_JOB_GUID_NOT_FOUND));

        Long dataJobId = dataJobEntity.getDataJobId();

        DataChannelEntity dataChannelEntity = dataJobEntity.getDataChannelEntity();
        String dataChannelCd = dataChannelEntity.getDataChannelCd();

        JobStatusTypeEntity jobStatusTypeEntity = dataJobEntity.getJobStatusTypeEntity();
        String jobStatusTypeCd = jobStatusTypeEntity.getJobStatusType();

        log.info("Updating data job entity of data job guid {}. ", datajobGuid);

        DataJobEntity newDataJobEntity = dataJobMapper.modelToEntity(dataJob);
        newDataJobEntity.setDataJobId(dataJobId);
        newDataJobEntity.getDataChannelEntity().setDataChannelCd(dataChannelCd);
        newDataJobEntity.getJobStatusTypeEntity().setJobStatusType(jobStatusTypeCd);
        dataJobRepository.save(newDataJobEntity);

        log.info("Data job updated of  data job guid {} updated.", datajobGuid);

        return dataJob;
    }
}
