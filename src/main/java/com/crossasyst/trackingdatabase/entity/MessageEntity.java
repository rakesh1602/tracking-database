package com.crossasyst.trackingdatabase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "msg")
public class MessageEntity {

    @Id
    @SequenceGenerator(name = "msg_seq_id", sequenceName = "msg_seq_id", initialValue = 5000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "msg_seq_id")
    @Column(name = "msg_Id")
    private Long msgId;

    @Transient
    UUID uuid=UUID.randomUUID();
    private UUID dataJobGuid= UUID.fromString(uuid.toString());

    @Column(name = "log_session_id")
    private String logSessionId;

    @Column(name = "processing_start_dt")
    private LocalDateTime processingStartDt;

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

    private UUID messageGuid= UUID.fromString(uuid.toString());

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
   /* @OneToMany(mappedBy = "messageEntity")
    private List<ObjectRefEntity> objectRefEntity;*/

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "processing_status_type_id")
    private ProcessingStatusTypeEntity processingStatusTypeEntity;
}