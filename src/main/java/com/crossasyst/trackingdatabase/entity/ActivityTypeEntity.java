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
@Table(name = "activity_type")
public class ActivityTypeEntity {

    @Id
    @Column(name = "activity_type_cd")
    private String activityTypeCd;

    @Column(name = "description")
    private String description;

    @Column(name = "active_bit")
    private Short activeBit;


    @OneToMany
    @JoinColumn(name = "activity_entity_activity_id")
    private List<ActivityEntity> activityEntity;
}
