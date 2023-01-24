package com.crossasyst.trackingdatabase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_status_type")
public class JobStatusTypeEntity {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    /* @SequenceGenerator(name = "job_status_type_seq_id", sequenceName = "job_status_type_seq_id", initialValue = 100, allocationSize = 1)
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_status_type_seq_id")*/
    @Column(name = "job_status_type")
    private String jobStatusType;

    @Column(name = "description")
    private String description;

    @Column(name = "active_bit")
    private Short activeBit;

    @OneToMany(mappedBy = "jobStatusTypeEntity")
    private List<DataJobEntity> dataJobEntity;
}
