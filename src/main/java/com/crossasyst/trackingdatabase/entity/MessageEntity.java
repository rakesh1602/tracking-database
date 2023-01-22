package com.crossasyst.trackingdatabase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "msg")
public class MessageEntity {

    @Id
    @Column(name = "msg_Id")
    private Long msgId;

    @Column(name = "data_job_guid")
    private String dataJobGuid;

    @Column(name = "processing_status_type")
    private String processingStatusType;

    @Column(name = "log_session_id")
    private String logSessionId;

    @Column(name = "processing_start_dt")
    private Date processingStartDt;

    @Column(name = "processing_end_dt")
    private Date processingEndDt;

    @Column(name = "attributes")
    private String attributes;

    @Column(name = "subject_id")
    private String subjectId;

    @Column(name = "exception_message")
    private String exceptionMessage;

    @Column(name = "message_type")
    private String messageType;

    @Column(name = "message_guid")
    private String messageGuid;

    @Column(name = "previous_message_guid")
    private String previousMessageGuid;

    @Column(name = "external_patient_id")
    private String externalPatientId;

    @Column(name = "portal_consumer_id")
    private int portalConsumerId;

    @Column(name = "external_provider_id")
    private String externalProviderId;

    @Column(name = "portal_staff_id")
    private int portalStaffId;

    @Column(name = "external_message_id")
    private String externalMessageId;

    @Column(name = "revision")
    private Long revision;

    @Column(name = "error_cd")
    private String errorCd;

    @Column(name = "error_description")
    private String errorDescription;

    @Column(name = "error_severity")
    private String errorSeverity;

    @OneToMany(mappedBy = "messageEntity")
    private List<ActivityEntity> activityEntity;

    @OneToMany(mappedBy = "messageEntity")
    private List<ObjectRefEntity> objectRefEntity;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "processing_status_type_id")
    private ProcessingStatusTypeEntity processingStatusTypeEntity;
}
