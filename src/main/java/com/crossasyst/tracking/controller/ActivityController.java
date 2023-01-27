package com.crossasyst.tracking.controller;

import com.crossasyst.tracking.model.Activity;
import com.crossasyst.tracking.response.ActivityResponse;
import com.crossasyst.tracking.service.ActivityService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @PutMapping(path = "/activities/{activityID}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Activity> updateActivity(@PathVariable Integer activityID, @RequestBody @Valid Activity activity) {

        activity = activityService.updateActivity(activityID, activity);

        return new ResponseEntity<>(activity, HttpStatus.OK);
    }


    /**
     * @author Rakesh Chavan,Sanket Mishra
     */
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @GetMapping(path = "/activities/{messageID}")
    public ResponseEntity<Activity> searchActivities(@RequestParam(name = "messageId") Long messageId) {

        Activity activity = activityService.searchActivities(messageId);

        return new ResponseEntity<>(activity, HttpStatus.OK);
    }


}
