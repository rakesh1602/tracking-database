package com.crossasyst.trackingdatabase.controller;

import com.crossasyst.trackingdatabase.model.JobStatusType;
import com.crossasyst.trackingdatabase.service.JobStatusService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Get-job-status", description = "Get job status")
@RequestMapping(path = "v1")
@RestController
public class JobStatusController {

    private final JobStatusService jobStatusService;

    @Autowired
    public JobStatusController(JobStatusService jobStatusService) {
        this.jobStatusService = jobStatusService;
    }

    /**
     * @author Adika Dome, Vishal Pandey
     */
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @GetMapping(path = "datajobs/{datajobGuid}/status ")
    public ResponseEntity<JobStatusType> getJobStatus(@RequestParam(name = "datajobGuid") String dataJobGuid) {

        JobStatusType jobStatusType = jobStatusService.getJobStatus(dataJobGuid);

        return new ResponseEntity<>(jobStatusType, HttpStatus.OK);
    }
}
