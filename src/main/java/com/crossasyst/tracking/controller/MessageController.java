package com.crossasyst.tracking.controller;

import com.crossasyst.tracking.model.Message;
import com.crossasyst.tracking.repository.MessageRepository;
import com.crossasyst.tracking.response.MessageResponse;
import com.crossasyst.tracking.service.MessageService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Tag(name = "Create message", description = "Create message")
@RequestMapping(path = "v1")
@RestController
public class MessageController {

    private final MessageService messageService;
    private final MessageRepository messageRepository;

    @Autowired
    public MessageController(MessageService messageService, MessageRepository messageRepository) {
        this.messageService = messageService;
        this.messageRepository = messageRepository;
    }

    /**
     * @author Rakesh Chavan, Sanket Mishra
     */
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PostMapping(path = "/messages", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageResponse> createMessages(@RequestBody @Valid Message message) {

        MessageResponse messageResponse = messageService.createMsg(message);

        return new ResponseEntity<>(messageResponse, HttpStatus.OK);
    }

    /**
     * @author Rushi Kandekar,Raj Bokade
     */
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PutMapping(path = "/messages/{messageGuid}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> updateMessage(@PathVariable String messageGuid, @RequestBody @Valid Message message) {

        message = messageService.updateMsg(messageGuid, message);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
