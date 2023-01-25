package com.crossasyst.trackingdatabase.service;

import com.crossasyst.trackingdatabase.entity.ActivityEntity;
import com.crossasyst.trackingdatabase.mapper.ActivityMapper;
import com.crossasyst.trackingdatabase.model.Activity;
import com.crossasyst.trackingdatabase.repository.ActivityRepository;
import com.crossasyst.trackingdatabase.response.ActivityResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class ActivityService {

    private final ActivityMapper activityMapper;

    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityService(ActivityMapper activityMapper, ActivityRepository activityRepository) {
        this.activityMapper = activityMapper;
        this.activityRepository = activityRepository;
    }

    public ActivityResponse createActivity(Activity activity) {

        log.info("Create activity");

        ActivityEntity activityEntity=activityMapper.modelToEntity(activity);
        activityRepository.save(activityEntity);
        log.info("Activity details saved successfully.");

        ActivityResponse activityResponse=new ActivityResponse();
        activityResponse.setActivityId(activityEntity.getActivityId());

        return activityResponse;

    }

    public Activity updateActivity(Integer activityId, Activity activity) {

        Optional<ActivityEntity> optionalActivityEntity=activityRepository.findById(activityId);

        if(optionalActivityEntity.isPresent()){
            log.info("Activity id found");

            optionalActivityEntity.get().setActivityName(activity.getActivityName());
            optionalActivityEntity.get().setProcessingStartDate(activity.getProcessingStartDate());
            optionalActivityEntity.get().setProcessingEndDate(activity.getProcessingEndDate());
            optionalActivityEntity.get().setRevision(activity.getRevision());

            activityRepository.save(optionalActivityEntity.get());

            log.info("Activity updated");
        } else {
            log.info("Activity id not found");
        }
        return activity;
    }

    public Activity searchActivities(Long messageId) {

        Optional<ActivityEntity> optionalActivityEntity=activityRepository.findByMessageId(messageId);

        Activity activity=new Activity();

        if(optionalActivityEntity.isPresent()){
           activity=activityMapper.entityToModel(optionalActivityEntity.get());
            log.info("Found activities with message id {}", messageId);

        } else{
            log.info("Activity not found with the message id{}",messageId);
        }
        return  activity;
    }
}
