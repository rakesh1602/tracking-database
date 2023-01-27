package com.crossasyst.trackingdatabase.service;

import com.crossasyst.trackingdatabase.entity.MessageEntity;
import com.crossasyst.trackingdatabase.entity.NodeTypeEntity;
import com.crossasyst.trackingdatabase.entity.ObjectRefEntity;
import com.crossasyst.trackingdatabase.mapper.ObjectRefMapper;
import com.crossasyst.trackingdatabase.model.ObjectRef;
import com.crossasyst.trackingdatabase.repository.ObjectRefRepository;
import com.crossasyst.trackingdatabase.response.ObjectRefResponse;
import com.crossasyst.trackingdatabase.utils.Constants;
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

    /**
     * @author Uttam Thackrey,Vaibhav Jadhav
     */
    public ObjectRefResponse createObjectRef(ObjectRef objectRef) {

        log.info("Adding object ref");

        ObjectRefEntity objectRefEntity = objectRefMapper.modelToEntity(objectRef);
        objectRefRepository.save(objectRefEntity);

        log.info("Object ref details saved successfully.");

        ObjectRefResponse objectRefResponse = new ObjectRefResponse();
        objectRefResponse.setObjectRefId(objectRefEntity.getObjectRefId());

        log.info("Object red id {} ", objectRefResponse.getObjectRefId());

        return objectRefResponse;
    }

    /**
     * @author Uttam Thackrey,Vaibhav Jadhav
     */
    public ObjectRef updateObjectRef(Long objectRefId, ObjectRef objectRef) {

        log.info("Retrieving object ref of id {}.", objectRefId);

        ObjectRefEntity objectRefEntity = objectRefRepository.findById(objectRefId)
                .orElseThrow(() -> new IllegalArgumentException(Constants.OBJECT_REF_ID_NOT_FOUND));

        Long newObjectRefId = objectRefEntity.getObjectRefId();

        MessageEntity messageEntity = new MessageEntity();
        Long msgId = messageEntity.getMsgId();

        NodeTypeEntity nodeTypeEntity = new NodeTypeEntity();
        String nodeTypeCd = nodeTypeEntity.getNodeTypeCd();

        log.info("Updating object ref of id {} .", objectRefId);
        objectRefEntity = objectRefMapper.modelToEntity(objectRef);
        objectRefEntity.setObjectRefId(newObjectRefId);
        objectRefEntity.getMessageEntity().setMsgId(msgId);
        objectRefEntity.getNodeTypeEntity().setNodeTypeCd(nodeTypeCd);
        objectRefRepository.save(objectRefEntity);

        log.info("Object ref updated of object ref id {} .", objectRefId);

        return objectRef;
    }

    /**
     * @author Adika Dome, Vishal Pandey
     */
    public void patchObjectRefById(ObjectRef patchObjectRef, Long objectRefId) {
        ObjectRefEntity objectRefEntity = objectRefRepository.findById(objectRefId)
                .orElseThrow(() -> new IllegalArgumentException(Constants.OBJECT_REF_ID_NOT_FOUND));

        objectRefEntity.setObjectRef(patchObjectRef.getObjectRef());
        objectRefRepository.save(objectRefEntity);

        log.info("Patched object ref of id {}", objectRefId);
    }
}

