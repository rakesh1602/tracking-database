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
@Table(name = "data_channel")
public class DataChannelEntity {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "data_chanel_cd")
    private String dataChannelCd;

    @Column(name = "description")
    private String description;

    @Column(name = "active_bit")
    private Short activeBit;

    @OneToMany(mappedBy = "dataChannelEntity")
    private List<DataJobEntity> dataJobEntity;
}
