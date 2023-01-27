package com.crossasyst.trackingdatabase.service;

import com.crossasyst.trackingdatabase.entity.ActivityEntity;
import com.crossasyst.trackingdatabase.entity.ActivityTypeEntity;
import com.crossasyst.trackingdatabase.entity.MessageEntity;
import com.crossasyst.trackingdatabase.entity.ProcessingStatusTypeEntity;
import com.crossasyst.trackingdatabase.mapper.ActivityMapper;
import com.crossasyst.trackingdatabase.model.Activity;
import com.crossasyst.trackingdatabase.repository.ActivityRepository;
import com.crossasyst.trackingdatabase.response.ActivityResponse;
import com.crossasyst.trackingdatabase.utils.Constants;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Log4j2
public class ActivityService {

    private final ActivityMapper activityMapper;

    private final ActivityRepository activityRepository;

    private ActivityEntity activityEntity;

    private Activity activity;

    @Autowired
    public ActivityService(ActivityMapper activityMapper, ActivityRepository activityRepository) {
        this.activityMapper = activityMapper;
        this.activityRepository = activityRepository;
    }

    /**
     * @author Rakesh Chavan,Sanket Mishra
     */
    public ActivityResponse createActivity(Activity activity) {

        log.info("Adding activities.");

        ActivityEntity activityEntity = activityMapper.modelToEntity(activity);
        activityRepository.save(activityEntity);
        log.info("Activity details saved successfully.");

        ActivityResponse activityResponse = new ActivityResponse();
        activityResponse.setActivityId(activityEntity.getActivityId());
        log.info("Activity id {} ", activityResponse.getActivityId());

        return activityResponse;
    }

    /**
     * @author Rakesh Chavan,Sanket Mishra
     */
    public Activity searchActivities(Long messageId) {

        log.info("Finding activities of message id {} ", messageId);

        Optional<ActivityEntity> optionalActivityEntity = Optional.ofNullable(activityRepository.findByMessageId(messageId)
                .orElseThrow(() -> new IllegalArgumentException(Constants.MESSAGE_ID_NOT_FOUND)));

        if (optionalActivityEntity.isPresent()) {
            activity = activityMapper.entityToModel(optionalActivityEntity.get());
            log.info("Retrieving activities with message id {}", messageId);
        }
        return activity;
    }

    /**
     * @author Rushi Kandekar,Raj Bokade
     */
    public Activity updateActivity(Integer activityId, Activity activity) {

        log.info("Finding activities of activity id {} ", activityId);

        activityEntity = (activityRepository.findById(activityId)
                .orElseThrow(() -> new IllegalArgumentException(Constants.ACTIVITY_ID_NOT_FOUND)));

        Integer entityActivityId = activityEntity.getActivityId();

        ActivityTypeEntity activityTypeEntity = activityEntity.getActivityTypeEntity();
        String activityTypeCd = activityTypeEntity.getActivityTypeCd();

        MessageEntity messageEntity = activityEntity.getMessageEntity();
        Long msgId = messageEntity.getMsgId();

        ProcessingStatusTypeEntity processingStatusTypeEntity = activityEntity.getProcessingStatusTypeEntity();
        String processingTypeCd = processingStatusTypeEntity.getProcessingStatusTypeCd();

        log.info("Updating values of activities of activity id {} ", activityId);

        activityEntity = activityMapper.modelToEntity(activity);
        activityEntity.setActivityId(entityActivityId);
        activityEntity.getActivityTypeEntity().setActivityTypeCd(activityTypeCd);
        activityEntity.getMessageEntity().setMsgId(msgId);
        activityEntity.getProcessingStatusTypeEntity().setProcessingStatusTypeCd(processingTypeCd);
        activityRepository.save(activityEntity);

        log.info("Activities values updated of activity id {} ", activityId);

        return activity;
    }
}
