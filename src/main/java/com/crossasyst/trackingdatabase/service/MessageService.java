package com.crossasyst.trackingdatabase.service;

import com.crossasyst.trackingdatabase.entity.MessageEntity;
import com.crossasyst.trackingdatabase.entity.ProcessingStatusTypeEntity;
import com.crossasyst.trackingdatabase.mapper.MessageMapper;
import com.crossasyst.trackingdatabase.model.Message;
import com.crossasyst.trackingdatabase.repository.MessageRepository;
import com.crossasyst.trackingdatabase.response.MessageResponse;
import com.crossasyst.trackingdatabase.utils.Constants;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    /**
     * @author Rakesh Chavan, Sanket Mishra
     */
    public MessageResponse createMsg(Message message) {

        log.info("Adding message");

        MessageEntity messageEntity = messageMapper.modelToEntity(message);
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

        log.info("Updating message of message Guid {} .", messageGuid);
        MessageEntity newMessageEntity = messageMapper.modelToEntity(message);
        newMessageEntity.setMsgId(msgId);
        messageEntity.getProcessingStatusTypeEntity().setProcessingStatusTypeCd(processingStatusTypeCd);
        messageRepository.save(newMessageEntity);

        log.info("Message updated of message Guid {} .", messageGuid);

        return message;
    }
}
