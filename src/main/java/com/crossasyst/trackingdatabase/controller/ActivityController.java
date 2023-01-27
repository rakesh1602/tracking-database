package com.crossasyst.trackingdatabase.controller;

import com.crossasyst.trackingdatabase.model.Activity;
import com.crossasyst.trackingdatabase.response.ActivityResponse;
import com.crossasyst.trackingdatabase.service.ActivityService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Create activity", description = "Create activity")
@RequestMapping(path = "v1")
@RestController
public class ActivityController {

    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }


    /**
     * @author Rakesh Chavan,Sanket Mishra
     */
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PostMapping(path = "/activities", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<ActivityResponse> createActivity(@RequestBody @Valid Activity activity) {

        ActivityResponse activityResponse = activityService.createActivity(activity);

        return new ResponseEntity<>(activityResponse, HttpStatus.OK);
    }


    /**
     * @author Rushi Kandekar,Raj Bokade
     */
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PutMapping(path = "/activities/{activityId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Activity> updateActivity(@PathVariable Integer activityId, @RequestBody @Valid Activity activity) {

        activity = activityService.updateActivity(activityId, activity);

        return new ResponseEntity<>(activity, HttpStatus.OK);
    }


    /**
     * @author Rakesh Chavan,Sanket Mishra
     */
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @GetMapping(path = "/activities/{messageId}")
    public ResponseEntity<Activity> searchActivities(@RequestParam(name = "messageId") Long messageId) {

        Activity activity = activityService.searchActivities(messageId);

        return new ResponseEntity<>(activity, HttpStatus.OK);
    }


}
