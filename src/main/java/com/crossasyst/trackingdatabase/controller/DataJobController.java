package com.crossasyst.trackingdatabase.controller;

import com.crossasyst.trackingdatabase.model.DataJob;
import com.crossasyst.trackingdatabase.model.JobStatusType;
import com.crossasyst.trackingdatabase.response.DataJobResponse;
import com.crossasyst.trackingdatabase.service.DataJobService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "create-data-jobs", description = "Create data jobs")
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
