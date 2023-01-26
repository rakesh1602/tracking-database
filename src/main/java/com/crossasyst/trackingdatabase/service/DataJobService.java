package com.crossasyst.trackingdatabase.service;

import com.crossasyst.trackingdatabase.entity.DataChannelEntity;
import com.crossasyst.trackingdatabase.entity.DataJobEntity;
import com.crossasyst.trackingdatabase.entity.JobStatusTypeEntity;
import com.crossasyst.trackingdatabase.mapper.DataJobMapper;
import com.crossasyst.trackingdatabase.model.DataJob;
import com.crossasyst.trackingdatabase.repository.DataJobRepository;
import com.crossasyst.trackingdatabase.response.DataJobResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        dataJobResponse.setDataJobGuid(dataJobEntity.getDataJobGUID());

        return dataJobResponse;
    }

    public DataJob updateJob(String datajobGuid, DataJob dataJob) {

        DataJobEntity dataJobEntity=dataJobRepository.findByDataJobGuid(datajobGuid);
        Long dataJobId= dataJobEntity.getDataJobId();

        DataChannelEntity dataChannelEntity=dataJobEntity.getDataChannelEntity();
        String dataChannelCd=dataChannelEntity.getDataChannelCd();

        JobStatusTypeEntity jobStatusTypeEntity=dataJobEntity.getJobStatusTypeEntity();
        String jobStatusTypeCd=jobStatusTypeEntity.getJobStatusType();

        DataJobEntity newDataJobEntity=dataJobMapper.modelToEntity(dataJob);
        newDataJobEntity.setDataJobId(dataJobId);
        newDataJobEntity.getDataChannelEntity().setDataChannelCd(dataChannelCd);
        newDataJobEntity.getJobStatusTypeEntity().setJobStatusType(jobStatusTypeCd);
        dataJobRepository.save(newDataJobEntity);

        log.info("Updated");

        return dataJob;


    }

    /*public DataJob updateJob(String datajobGuid, DataJob dataJob) {

        Optional<DataJobEntity> optionalDataJobEntity = dataJobRepository.findByGuid(datajobGuid);

        DataJobEntity dataJobEntity = new DataJobEntity();
        if (optionalDataJobEntity.isPresent()) {

            log.info("Data job found with dataJobGuid {}", datajobGuid);

            optionalDataJobEntity.get().setJobDirection(dataJob.getJobDirection());
            optionalDataJobEntity.get().setDataJobGUID(dataJob.getDataJobGuid());
            optionalDataJobEntity.get().setInputFileName(dataJob.getInputFileName());
            optionalDataJobEntity.get().setProcessingStartDt(dataJob.getProcessingStartDt());
            optionalDataJobEntity.get().setProcessingEndDt(dataJob.getProcessingEndDt());
            optionalDataJobEntity.get().setDataFeed(dataJob.getDataFeed());
            optionalDataJobEntity.get().setDataSource(dataJob.getDataSource());
            optionalDataJobEntity.get().setDataPartner(dataJob.getDataPartner());
            optionalDataJobEntity.get().setMsgType(dataJob.getMsgType());
            optionalDataJobEntity.get().setJobType(dataJob.getJobType());
            optionalDataJobEntity.get().setExternalSystemName(dataJob.getExternalSystemName());
            optionalDataJobEntity.get().setOrgId(dataJob.getOrgId());
            optionalDataJobEntity.get().setOrgUuid(dataJob.getOrgUuid());
            dataJobRepository.save(optionalDataJobEntity.get());

            log.info("Data job updated");


            *//*dataJobEntity = dataJobMapper.modelToEntity(dataJob);
            dataJobRepository.save(dataJobEntity);*//*

        } else {
            log.info("Data job not found with dataJobGuid {}", datajobGuid);
        }

        return dataJob;
    }*/

}
