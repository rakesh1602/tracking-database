package com.crossasyst.trackingdatabase.service;

import com.crossasyst.trackingdatabase.entity.ProcessingStatusTypeEntity;
import com.crossasyst.trackingdatabase.mapper.ProcessingStatusTypeMapper;
import com.crossasyst.trackingdatabase.model.ProcessingStatusType;
import com.crossasyst.trackingdatabase.repository.ProcessingStatusTypeRepository;
import com.crossasyst.trackingdatabase.utils.Constants;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Log4j2
public class ProcessingStatusTypeService {

    private final ProcessingStatusTypeRepository processingStatusTypeRepository;

    private final ProcessingStatusTypeMapper processingStatusTypeMapper;

    private ProcessingStatusType processingStatusType;

    @Autowired
    public ProcessingStatusTypeService(ProcessingStatusTypeRepository processingStatusTypeRepository, ProcessingStatusTypeMapper processingStatusTypeMapper) {
        this.processingStatusTypeRepository = processingStatusTypeRepository;
        this.processingStatusTypeMapper = processingStatusTypeMapper;
    }

    /**
     * @author Adika Dome, Vishal Pandey
     */
    public ProcessingStatusType getProcessingStatus(String dataJobGuid) {

        log.info("Finding process status type of data job guid {} .", dataJobGuid);

        ProcessingStatusTypeEntity processingStatusTypeEntity = processingStatusTypeRepository.findByDataJobGuid(dataJobGuid)
                .orElseThrow(() -> new IllegalArgumentException(Constants.DATA_JOB_GUID_NOT_FOUND));

        processingStatusType = processingStatusTypeMapper.entityToModel(processingStatusTypeEntity);
        log.info("Retrieving process status type of data job guid {} .", dataJobGuid);

        return processingStatusType;
    }

}
