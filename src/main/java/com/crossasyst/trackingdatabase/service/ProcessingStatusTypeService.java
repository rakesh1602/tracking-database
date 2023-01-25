package com.crossasyst.trackingdatabase.service;

import com.crossasyst.trackingdatabase.entity.ProcessingStatusTypeEntity;
import com.crossasyst.trackingdatabase.mapper.ProcessingStatusTypeMapper;
import com.crossasyst.trackingdatabase.model.ProcessingStatusType;
import com.crossasyst.trackingdatabase.repository.ProcessingStatusTypeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class ProcessingStatusTypeService {

    private final ProcessingStatusTypeRepository processingStatusTypeRepository;

    private final ProcessingStatusTypeMapper processingStatusTypeMapper;

    @Autowired
    public ProcessingStatusTypeService(ProcessingStatusTypeRepository processingStatusTypeRepository, ProcessingStatusTypeMapper processingStatusTypeMapper) {
        this.processingStatusTypeRepository = processingStatusTypeRepository;
        this.processingStatusTypeMapper = processingStatusTypeMapper;
    }

    public ProcessingStatusType getProcessingStatus(String datajobGuid) {

        Optional<ProcessingStatusTypeEntity> optionalProcessingStatusTypeEntity=processingStatusTypeRepository.findByMsgGuid(datajobGuid);

        ProcessingStatusType processingStatusType=new ProcessingStatusType();

        if(optionalProcessingStatusTypeEntity.isPresent()){
            processingStatusType=processingStatusTypeMapper.entityToModel(optionalProcessingStatusTypeEntity.get());
            log.info("Data job guid id {} found ",datajobGuid);
        } else {
            log.info("Data job guid id {} not found", datajobGuid);
        }
        return processingStatusType;
    }

}
