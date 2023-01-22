package com.crossasyst.trackingdatabase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "activity")
public class ProcessingStatusTypeEntity{

    @Id
    @Column(name = "processing_status_type")
    private String processingStatusType;

    @Column(name = "description")
    private String description;

    @Column(name = "active_bit")
    private Long activeBit;

    @OneToMany(mappedBy = "processingStatusTypeEntity")
    private List<ActivityEntity> activityEntity;

    @OneToMany(mappedBy = "processingStatusTypeEntity" )
    private List<MessageEntity> messageEntity;
}
