package com.crossasyst.trackingdatabase.controller;

import com.crossasyst.trackingdatabase.model.ProcessingStatusType;
import com.crossasyst.trackingdatabase.service.ProcessingStatusTypeService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Get processing status type", description = "Get processing status type")
@RequestMapping(path = "v1")
@RestController
public class ProcessingStatusTypeController {

    private final ProcessingStatusTypeService processingStatusTypeService;

    @Autowired
    public ProcessingStatusTypeController(ProcessingStatusTypeService processingStatusTypeService) {
        this.processingStatusTypeService = processingStatusTypeService;
    }

    /**
     * @author Adika Dome, Vishal Pandey
     */
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @GetMapping(path = "/datajobs/{datajobGuid}/processing-status")
    public ResponseEntity<ProcessingStatusType> getProcessingType(@RequestParam(name = "datajobGuid") String dataJobGuid) {

        ProcessingStatusType processingStatusType = processingStatusTypeService.getProcessingStatus(dataJobGuid);

        return new ResponseEntity<>(processingStatusType, HttpStatus.OK);
    }
}
