package com.crossasyst.trackingdatabase.entity;

import com.crossasyst.trackingdatabase.entity.base.BaseEntity;
import com.crossasyst.trackingdatabase.utils.UUIDGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "data_job")
public class DataJobEntity extends BaseEntity {

    @Id
    @SequenceGenerator(name = "data_job_seq_id", sequenceName = "data_job_seq_id", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_job_seq_id")
    @Column(name = "data_job_id")
    private Long dataJobId;

    @Column(name = "job_direction")
    private String jobDirection;

    @Transient
    UUIDGenerator uuidGenerator = new UUIDGenerator();

    @Column(name = "data_job_guid")
    private String dataJobGUID = uuidGenerator.getDataJobGuid();

    @Column(name = "input_file_name")
    private String inputFileName;

    @Column(name = "processing_start_dt")
    private LocalDateTime processingStartDt;

    @Column(name = "processing_end_dt")
    private LocalDateTime processingEndDt;

    @Column(name = "data_feed")
    private String dataFeed;

    @Column(name = "data_source")
    private String dataSource;

    @Column(name = "data_partner")
    private String dataPartner;

    @Column(name = "msg_type")
    private String msgType;

    @Column(name = "job_type")
    private String jobType;

    @Column(name = "external_system_name")
    private String externalSystemName;

    @Column(name = "org_id")
    private Long orgId;

    @Column(name = "org_uuid")
    private String orgUuid;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "data_channel_id", nullable = false)
    private DataChannelEntity dataChannelEntity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "job_status_type_id", nullable = false)
    private JobStatusTypeEntity jobStatusTypeEntity;
}
