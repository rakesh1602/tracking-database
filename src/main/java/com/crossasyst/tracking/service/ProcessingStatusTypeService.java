package com.crossasyst.tracking.service;

import com.crossasyst.tracking.entity.ProcessingStatusTypeEntity;
import com.crossasyst.tracking.mapper.ProcessingStatusTypeMapper;
import com.crossasyst.tracking.model.ProcessingStatusType;
import com.crossasyst.tracking.repository.ProcessingStatusTypeRepository;
import com.crossasyst.tracking.utils.Constants;
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
