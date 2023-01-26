package com.crossasyst.trackingdatabase.service;

import com.crossasyst.trackingdatabase.entity.MessageEntity;
import com.crossasyst.trackingdatabase.entity.NodeTypeEntity;
import com.crossasyst.trackingdatabase.entity.ObjectRefEntity;
import com.crossasyst.trackingdatabase.mapper.ObjectRefMapper;
import com.crossasyst.trackingdatabase.model.Message;
import com.crossasyst.trackingdatabase.model.ObjectRef;
import com.crossasyst.trackingdatabase.repository.ObjectRefRepository;
import com.crossasyst.trackingdatabase.response.ObjectRefResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        objectRefRepository.save(objectRefEntity);

        log.info("Object ref saved successfully.");

        ObjectRefResponse objectRefResponse=new ObjectRefResponse();
        objectRefResponse.setObjectRefId(objectRefEntity.getObjectRefId());

        return objectRefResponse;


    }

    public ObjectRef updateObjectRef(Long objectRefId, ObjectRef objectRef) {
        ObjectRefEntity objectRefEntity=objectRefRepository.findById(objectRefId).get();

        Long newObjectRefId=objectRefEntity.getObjectRefId();

        MessageEntity messageEntity=new MessageEntity();
        Long msgId=messageEntity.getMsgId();

        NodeTypeEntity nodeTypeEntity=new NodeTypeEntity();
        String nodeTypeCd= nodeTypeEntity.getNodeTypeCd();

        objectRefEntity=objectRefMapper.modelToEntity(objectRef);
        objectRefEntity.setObjectRefId(newObjectRefId);
        objectRefEntity.getMessageEntity().setMsgId(msgId);
        objectRefEntity.getNodeTypeEntity().setNodeTypeCd(nodeTypeCd);
        objectRefRepository.save(objectRefEntity);

        log.info("Updated");

        return objectRef;

    }

    public void patchObjectRefById(ObjectRef patchObjectRef, Long objectRefId) {
        Optional<ObjectRefEntity> objectRefEntityOptional=objectRefRepository.findById(objectRefId);
        if(objectRefEntityOptional.isPresent()){
            objectRefEntityOptional.get().setObjectRef(patchObjectRef.getObjectRef());
            objectRefRepository.save(objectRefEntityOptional.get());
            log.info("Patch object ref id {}",objectRefId);
        } else {
            log.info("Object id {} not found", objectRefId);
        }
    }
}
