package com.crossasyst.trackingdatabase.entity;

import com.crossasyst.trackingdatabase.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "activity")
public class ActivityEntity extends BaseEntity {

    @Id
    @SequenceGenerator(name = "activity_seq_id", sequenceName = "activity_seq_id", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "activity_seq_id")
    private Integer activityId;

    @Column(name = "activity_name")
    private String activityName;

    @Column(name = "processing_start_date")
    private LocalDateTime processingStartDate;

    @Column(name = "processing_end_date")
    private LocalDateTime processingEndDate;

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
