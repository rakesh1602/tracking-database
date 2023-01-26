package com.crossasyst.trackingdatabase.entity;

import com.crossasyst.trackingdatabase.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "object_ref")
public class ObjectRefEntity extends BaseEntity {

    @Id
    @SequenceGenerator(name = "obj_ref_seq_id", sequenceName = "obj_ref_seq_id", initialValue = 2000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "obj_ref_seq_id")
    @Column(name = "object_ref_id")
    private Long objectRefId;

    @Column(name = "objectRef")
    private String objectRef;

    @Column(name = "mes_GUID")
    private String mesGuid;

    @Column(name = "revision")
    private Integer revision;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "message_entity_msg_id")
    private MessageEntity messageEntity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "node_type_entity_node_type_cd")
    private NodeTypeEntity nodeTypeEntity;
}
