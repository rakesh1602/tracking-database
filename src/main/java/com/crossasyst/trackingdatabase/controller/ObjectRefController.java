package com.crossasyst.trackingdatabase.controller;

import com.crossasyst.trackingdatabase.model.Message;
import com.crossasyst.trackingdatabase.model.ObjectRef;
import com.crossasyst.trackingdatabase.response.MessageResponse;
import com.crossasyst.trackingdatabase.response.ObjectRefResponse;
import com.crossasyst.trackingdatabase.service.ObjectRefService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Create object ref", description = "Create object red")
@RequestMapping(path = "v1")
@RestController
public class ObjectRefController {

    private final ObjectRefService objectRefService;

    @Autowired
    public ObjectRefController(ObjectRefService objectRefService) {
        this.objectRefService = objectRefService;
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PostMapping(path = "/object-refs", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectRefResponse> createObjectRef(@RequestBody ObjectRef objectRef) {

       ObjectRefResponse objectRefResponse=objectRefService.createObjectRef(objectRef);
       return new ResponseEntity<>(objectRefResponse, HttpStatus.OK);
    }
}
