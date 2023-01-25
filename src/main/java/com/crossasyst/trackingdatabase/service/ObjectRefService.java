package com.crossasyst.trackingdatabase.service;

import com.crossasyst.trackingdatabase.entity.MessageEntity;
import com.crossasyst.trackingdatabase.entity.ObjectRefEntity;
import com.crossasyst.trackingdatabase.mapper.ObjectRefMapper;
import com.crossasyst.trackingdatabase.model.Message;
import com.crossasyst.trackingdatabase.model.ObjectRef;
import com.crossasyst.trackingdatabase.repository.ObjectRefRepository;
import com.crossasyst.trackingdatabase.response.ObjectRefResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ObjectRefService {

    private final ObjectRefMapper objectRefMapper;

    private final ObjectRefRepository objectRefRepository;

    @Autowired
    public ObjectRefService(ObjectRefMapper objectRefMapper, ObjectRefRepository objectRefRepository) {
        this.objectRefMapper = objectRefMapper;
        this.objectRefRepository = objectRefRepository;
    }


    public ObjectRefResponse createObjectRef(ObjectRef objectRef) {

        log.info("Create object ref");

        ObjectRefEntity objectRefEntity=objectRefMapper.modelToEntity(objectRef);

        MessageEntity messageEntity=new MessageEntity();
        messageEntity.setMsgId(messageEntity.getMsgId());

        objectRefRepository.save(objectRefEntity);

        log.info("Object ref saved successfully.");

        ObjectRefResponse objectRefResponse=new ObjectRefResponse();
        objectRefResponse.setObjectRefId(objectRefEntity.getObjectRefId());

        return objectRefResponse;


    }
}
