package com.crossasyst.tracking.entity;

import com.crossasyst.tracking.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "msg")
public class MessageEntity extends BaseEntity {

    @Id
    @SequenceGenerator(name = "msg_seq_id", sequenceName = "msg_seq_id", initialValue = 5000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "msg_seq_id")
    @Column(name = "msg_Id")
    private Long msgId;

    @Column(name = "data_job_guid")
    private String dataJobGUID;

    @Column(name = "log_session_id")
    private String logSessionId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "processing_start_dt")
    private LocalDateTime processingStartDt;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "processing_end_dt")
    private LocalDateTime processingEndDt;

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
    private Integer revision;

    @Column(name = "error_cd")
    private String errorCd;

    @Column(name = "error_description")
    private String errorDescription;

    @Column(name = "error_severity")
    private String errorSeverity;

    /* @OneToMany(mappedBy = "messageEntity")
     private List<ActivityEntity> activityEntity;
 */
    /*@OneToMany(mappedBy = "messageEntity")
    private List<ObjectRefEntity> objectRefEntity;*/

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "processing_status_type_id")
    private ProcessingStatusTypeEntity processingStatusTypeEntity;
}
