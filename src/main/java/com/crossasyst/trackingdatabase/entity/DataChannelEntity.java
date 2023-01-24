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
@Table(name = "data_channel")
public class DataChannelEntity {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
   /* @SequenceGenerator(name = "data_channel_seq_id", sequenceName = "data_channel_seq_id", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_channel_seq_id")*/
    @Column(name = "data_chanel_cd")
    private String dataChannelCd;

    @Column(name = "description")
    private String description;

    @Column(name = "active_bit")
    private Short activeBit;

    @OneToMany(mappedBy = "dataChannelEntity")
    private List<DataJobEntity> dataJobEntity;
}
