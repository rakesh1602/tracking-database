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
@Table(name = "data_channel")
public class DataChannelEntity {

    @Id
    @Column(name = "data_chanel_cd")
    private String dataChannelCd;

    @Column(name = "description")
    private String description;

    @Column(name = "active_bit")
    private Short activeBit;

    /*@OneToMany(mappedBy = "dataChannelEntity")
    private List<DataJobEntity> dataJobEntity;*/
}
