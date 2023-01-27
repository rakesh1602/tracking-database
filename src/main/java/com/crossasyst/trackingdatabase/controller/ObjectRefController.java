package com.crossasyst.trackingdatabase.controller;

import com.crossasyst.trackingdatabase.model.ObjectRef;
import com.crossasyst.trackingdatabase.response.ObjectRefResponse;
import com.crossasyst.trackingdatabase.service.ObjectRefService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Tag(name = "Create object ref", description = "Create object red")
@RequestMapping(path = "v1")
@RestController
public class ObjectRefController {

    private final ObjectRefService objectRefService;

    @Autowired
    public ObjectRefController(ObjectRefService objectRefService) {
        this.objectRefService = objectRefService;
    }

    /**
     * @author Uttam Thackrey,Vaibhav Jadhav
     */
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PostMapping(path = "/object-refs", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectRefResponse> createObjectRef(@RequestBody @Valid ObjectRef objectRef) {

        ObjectRefResponse objectRefResponse = objectRefService.createObjectRef(objectRef);

        return new ResponseEntity<>(objectRefResponse, HttpStatus.OK);
    }

    /**
     * @author Uttam Thackrey,Vaibhav Jadhav
     */
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PutMapping(path = "/object-refs/{objectRefId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectRef> updateObjectRef(@PathVariable Long objectRefId, @RequestBody @Valid ObjectRef objectRef) {

        objectRef = objectRefService.updateObjectRef(objectRefId, objectRef);

        return new ResponseEntity<>(objectRef, HttpStatus.OK);
    }

    /**
     * @author Adika Dome, Vishal Pandey
     */
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PatchMapping(path = "/object-refs/{objectRefId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectRef> patchObjectRefById(@PathVariable Long objectRefId, @RequestBody @Valid ObjectRef patchObjectRef) {

        objectRefService.patchObjectRefById(patchObjectRef, objectRefId);

        return ResponseEntity.ok().build();
    }
}
