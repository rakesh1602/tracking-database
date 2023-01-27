package com.crossasyst.tracking.service;

import com.crossasyst.tracking.entity.MessageEntity;
import com.crossasyst.tracking.entity.NodeTypeEntity;
import com.crossasyst.tracking.entity.ObjectRefEntity;
import com.crossasyst.tracking.mapper.ObjectRefMapper;
import com.crossasyst.tracking.model.ObjectRef;
import com.crossasyst.tracking.model.patch.ObjectRefPatch;
import com.crossasyst.tracking.repository.ObjectRefRepository;
import com.crossasyst.tracking.response.ObjectRefResponse;
import com.crossasyst.tracking.utils.Constants;
import com.crossasyst.tracking.utils.UUIDGenerator;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ObjectRefService {

    private final ObjectRefMapper objectRefMapper;

    private final ObjectRefRepository objectRefRepository;

    private final UUIDGenerator uuidGenerator=new UUIDGenerator();

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
        objectRefEntity.setMsgGuid(uuidGenerator.generateUUID());
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
    public ObjectRef updateObjectRef(Long objectRefID, ObjectRef objectRef) {

        log.info("Retrieving object ref of id {}.", objectRefID);

        ObjectRefEntity objectRefEntity = objectRefRepository.findById(objectRefID)
                .orElseThrow(() -> new IllegalArgumentException(Constants.OBJECT_REF_ID_NOT_FOUND));

        Long newObjectRefId = objectRefEntity.getObjectRefId();

        MessageEntity messageEntity = objectRefEntity.getMessageEntity();
        Long msgId = messageEntity.getMsgId();

        String msgGuid=objectRefEntity.getMsgGuid();

        NodeTypeEntity nodeTypeEntity = objectRefEntity.getNodeTypeEntity();
        String nodeTypeCd = nodeTypeEntity.getNodeTypeCd();

        log.info("Updating object ref of id {} .", objectRefID);
        ObjectRefEntity newObjectRefEntity = objectRefMapper.modelToEntity(objectRef);
        newObjectRefEntity.setObjectRefId(newObjectRefId);
        newObjectRefEntity.setMsgGuid(msgGuid);
        newObjectRefEntity.getMessageEntity().setMsgId(msgId);
        newObjectRefEntity.getNodeTypeEntity().setNodeTypeCd(nodeTypeCd);
        objectRefRepository.save(newObjectRefEntity);

        log.info("Object ref updated of object ref id {} .", objectRefID);

        return objectRef;
    }

    /**
     * @author Adika Dome, Vishal Pandey
     */
    public void patchObjectRefById(ObjectRefPatch objectRefPatch, Long objectRefID) {
        ObjectRefEntity objectRefEntity = objectRefRepository.findById(objectRefID)
                .orElseThrow(() -> new IllegalArgumentException(Constants.OBJECT_REF_ID_NOT_FOUND));

        objectRefEntity.setObjectRef(objectRefPatch.getObjectRef());
        objectRefRepository.save(objectRefEntity);

        log.info("Patched object ref of id {}", objectRefID);
    }
}

