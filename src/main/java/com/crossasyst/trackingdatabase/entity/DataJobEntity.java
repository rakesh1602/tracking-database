package com.crossasyst.trackingdatabase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "data_job")
public class DataJobEntity {

    @Id
    @SequenceGenerator(name = "data_job_seq_id", sequenceName = "data_job_seq_id", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "data_job_id")
    private Long dataJobId;

    @Column(name = "data_channel")
    private String dataChannel;

    @Column(name = "job_status_type_cd")
    private String jobStatusTypeCd;

    @Column(name = "job_direction")
    private String jobDirection;

    @Column(name = "data_job_guid")
    private String dataJobGuid;

    @Column(name = "input_file_name")
    private String inputFileName;

    @Column(name = "processing_start_dt")
    private String processingStartDt;

    @Column(name = "processing_end_dt")
    private String processingEndDt;

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

    UUID uuid = UUID.randomUUID();
    private String orgUuid = uuid.toString();

  /*  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "data_channel_id", nullable = true)
    private DataChannelEntity dataChannelEntity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "job_status_type_id")
    private JobStatusTypeEntity jobStatusTypeEntity;*/
}
