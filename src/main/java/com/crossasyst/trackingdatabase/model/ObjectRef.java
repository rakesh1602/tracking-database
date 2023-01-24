package com.crossasyst.trackingdatabase.model;

import com.crossasyst.trackingdatabase.entity.NodeTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjectRef {

    @NotBlank(message = "Object ref should not be empty or null")
    @Size(max = 10, message = "Object ref maximum size 10 character")
    private String objectRef;

    private String mesGuid;

    private Integer revision;

    //private Message message;

    private NodeTypeEntity nodeTypeEntity;
}
