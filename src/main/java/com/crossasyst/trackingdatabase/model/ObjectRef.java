package com.crossasyst.trackingdatabase.model;

import com.crossasyst.trackingdatabase.model.base.Base;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class ObjectRef extends Base {

    @NotBlank(message = "Object ref should not be empty or null")
    @Size(max = 10, message = "Object ref maximum size 10 character")
    private String objectRef;

    private String mesGuid;

    private Integer revision;

    private Message message;

    private NodeType nodeType;
}
