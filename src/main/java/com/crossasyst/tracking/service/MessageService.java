package com.crossasyst.tracking.service;

import com.crossasyst.tracking.entity.MessageEntity;
import com.crossasyst.tracking.entity.ProcessingStatusTypeEntity;
import com.crossasyst.tracking.mapper.MessageMapper;
import com.crossasyst.tracking.model.Message;
import com.crossasyst.tracking.repository.MessageRepository;
import com.crossasyst.tracking.response.MessageResponse;
import com.crossasyst.tracking.utils.Constants;
import com.crossasyst.tracking.utils.UUIDGenerator;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Log4j2
public class MessageService {

    private final MessageRepository messageRepository;

    private final MessageMapper messageMapper;

    private final UUIDGenerator uuidGenerator=new UUIDGenerator();

    @Autowired
    public MessageService(MessageRepository messageRepository, MessageMapper messageMapper) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
    }

    /**
     * @author Rakesh Chavan, Sanket Mishra
     */
    public MessageResponse createMsg(Message message) {

        log.info("Adding message");

        MessageEntity messageEntity = messageMapper.modelToEntity(message);
        messageEntity.setDataJobGUID(uuidGenerator.generateUUID());
        messageEntity.setMessageGuid(uuidGenerator.generateUUID());
        messageEntity.setPreviousMessageGuid(uuidGenerator.generateUUID());
        messageRepository.save(messageEntity);
        log.info("Message details saved successfully.");

        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessageId(messageEntity.getMsgId());
        messageResponse.setMessageGuid(messageEntity.getMessageGuid());
        log.info("Message id {}", messageResponse.getMessageId());

        return messageResponse;
    }

    /**
     * @author Rushi Kandekar,Raj Bokade
     */
    public Message updateMsg(String messageGuid, Message message) {

        log.info("Retrieving message of message Guid{} .", messageGuid);

        MessageEntity messageEntity = messageRepository.findByMessageGuid(messageGuid)
                .orElseThrow(() -> new IllegalArgumentException(Constants.MESSAGE_GUID_NOT_FOUND));

        Long msgId = messageEntity.getMsgId();
        ProcessingStatusTypeEntity processingStatusTypeEntity = messageEntity.getProcessingStatusTypeEntity();
        String processingStatusTypeCd = processingStatusTypeEntity.getProcessingStatusTypeCd();
        String dataJobGuid=messageEntity.getDataJobGUID();
        String msgGuid= messageEntity.getMessageGuid();
        String previousMsgGuid=messageEntity.getPreviousMessageGuid();

        log.info("Updating message of message Guid {} .", messageGuid);
        MessageEntity newMessageEntity = messageMapper.modelToEntity(message);
        newMessageEntity.setMsgId(msgId);
        newMessageEntity.getProcessingStatusTypeEntity().setProcessingStatusTypeCd(processingStatusTypeCd);
        newMessageEntity.setMessageGuid(msgGuid);
        newMessageEntity.setDataJobGUID(dataJobGuid);
        newMessageEntity.setPreviousMessageGuid(previousMsgGuid);
        messageRepository.save(newMessageEntity);

        log.info("Message updated of message Guid {} .", messageGuid);

        return message;
    }
}
