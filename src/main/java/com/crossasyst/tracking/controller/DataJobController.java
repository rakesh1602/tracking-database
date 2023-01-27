package com.crossasyst.tracking.controller;

import com.crossasyst.tracking.model.DataJob;
import com.crossasyst.tracking.response.DataJobResponse;
import com.crossasyst.tracking.service.DataJobService;
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

@Tag(name = "create datajobs", description = "Create datajobs")
@RequestMapping(path = "v1")
@RestController
public class DataJobController {

    private final DataJobService dataJobService;

    @Autowired
    public DataJobController(DataJobService dataJobService) {
        this.dataJobService = dataJobService;
    }

    /**
     * @author Rakesh Chavan, Sanket Mishra
     */
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PostMapping(path = "/datajobs", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DataJobResponse> createJob(@RequestBody @Valid DataJob dataJob) {

        DataJobResponse dataJobResponse = dataJobService.createJob(dataJob);

        return new ResponseEntity<>(dataJobResponse, HttpStatus.OK);
    }

    /**
     * @author Rushi Kandekar,Raj Bokade
     */
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PutMapping(path = "/datajobs/{datajobGuid}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DataJob> updateJob(@PathVariable String datajobGuid, @RequestBody @Valid DataJob dataJob) {

        dataJob = dataJobService.updateJob(datajobGuid, dataJob);

        return new ResponseEntity<>(dataJob, HttpStatus.OK);
    }


}
