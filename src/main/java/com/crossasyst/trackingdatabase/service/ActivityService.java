package com.crossasyst.trackingdatabase.service;

import com.crossasyst.trackingdatabase.entity.ActivityEntity;
import com.crossasyst.trackingdatabase.mapper.ActivityMapper;
import com.crossasyst.trackingdatabase.model.Activity;
import com.crossasyst.trackingdatabase.repository.ActivityRepository;
import com.crossasyst.trackingdatabase.response.ActivityResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
