package com.crossasyst.tracking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "processing_status_type")
public class ProcessingStatusTypeEntity {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "processing_status_type_cd")
    private String processingStatusTypeCd;

    @Column(name = "description")
    private String description;

    @Column(name = "active_bit")
    private Long activeBit;

    @OneToMany(mappedBy = "processingStatusTypeEntity")
    private List<MessageEntity> messageEntity;
}
