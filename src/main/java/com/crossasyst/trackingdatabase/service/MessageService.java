package com.crossasyst.trackingdatabase.service;

import com.crossasyst.trackingdatabase.entity.MessageEntity;
import com.crossasyst.trackingdatabase.mapper.MessageMapper;
import com.crossasyst.trackingdatabase.model.Message;
import com.crossasyst.trackingdatabase.repository.MessageRepository;
import com.crossasyst.trackingdatabase.response.MessageResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Log4j2
public class MessageService {

    private final MessageRepository messageRepository;

    private final MessageMapper messageMapper;

    @Autowired
    public MessageService(MessageRepository messageRepository, MessageMapper messageMapper) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
    }

    public MessageResponse createMsg(Message message) {

        log.info("Create Message");

        MessageEntity messageEntity=messageMapper.modelToEntity(message);
        messageRepository.save(messageEntity);
        log.info("Message saved successfully.");

        MessageResponse messageResponse=new MessageResponse();
        messageResponse.setMessageId(messageEntity.getMsgId());
        messageResponse.setMessageGuid(String.valueOf(messageEntity.getMessageGuid()));

        return messageResponse;

    }


    public Message updateMsg(UUID messageGuid, Message message) {

        Optional<MessageEntity> optionalMessageEntity=messageRepository.findByGuid(messageGuid);

        if(optionalMessageEntity.isPresent()){
            log.info("Message guid found");
            optionalMessageEntity.get().setDataJobGuid(message.getDataJobGuid());
            optionalMessageEntity.get().setLogSessionId(message.getLogSessionId());
            optionalMessageEntity.get().setProcessingStartDt(message.getProcessingStartDt());
            optionalMessageEntity.get().setProcessingEndDt(message.getProcessingEndDt());
            optionalMessageEntity.get().setAttributes(message.getAttributes());
            optionalMessageEntity.get().setSubjectId(message.getSubjectId());
            optionalMessageEntity.get().setExceptionMessage(message.getExceptionMessage());
            optionalMessageEntity.get().setMessageType(message.getMessageType());
            optionalMessageEntity.get().setMessageGuid(message.getMessageGuid());
            optionalMessageEntity.get().setPreviousMessageGuid(message.getPreviousMessageGuid());
            optionalMessageEntity.get().setExternalPatientId(message.getExternalPatientId());
            optionalMessageEntity.get().setPortalConsumerId(message.getPortalConsumerId());
            optionalMessageEntity.get().setExternalMessageId(message.getExternalMessageId());
            optionalMessageEntity.get().setPortalStaffId(message.getPortalStaffId());
            optionalMessageEntity.get().setRevision(message.getRevision());
            optionalMessageEntity.get().setErrorCd(message.getErrorCd());
            optionalMessageEntity.get().setErrorDescription(message.getErrorDescription());
            optionalMessageEntity.get().setErrorDescription(message.getErrorDescription());
            optionalMessageEntity.get().setErrorSeverity(message.getErrorSeverity());

            messageRepository.save(optionalMessageEntity.get());

            log.info("Message updated.");
        } else {
            log.info("Message guid not found");
        }

        return message;

    }
}
