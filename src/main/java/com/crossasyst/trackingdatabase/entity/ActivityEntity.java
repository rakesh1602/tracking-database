package com.crossasyst.trackingdatabase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "activity")
public class ActivityEntity {
    @Id
    @Column(name = "activity_id")
    private Integer activityId;

    @Column(name = "activity_type")
    private String activityType;

    @Column(name = "msg_id")
    private Integer msgId;

    @Column(name = "processing_status_type_cd")
    private String processingStatusTypeCd;

    @Column(name = "activity_name")
    private String activityName;

    @Column(name = "processing_start_date")
    private String processingStartDate;

    @Column(name = "processing_end_date")
    private String processingEndDate;

    @Column(name = "revision")
    private Integer revision;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "message_entity_msg_id")
    private MessageEntity messageEntity;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "activity_type_entity_id", nullable = false)
    private ActivityTypeEntity activityTypeEntity;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "processing_status_type_entity_id", nullable = false)
    private ProcessingStatusTypeEntity processingStatusTypeEntity;
}
