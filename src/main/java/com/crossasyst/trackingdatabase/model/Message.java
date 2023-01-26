package com.crossasyst.trackingdatabase.model;

import com.crossasyst.trackingdatabase.model.base.Base;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class Message extends Base {

    @NotBlank(message = "Log session id should not be empty or null ")
    private String logSessionId;

    private LocalDateTime processingStartDt;

    private LocalDateTime processingEndDt;

    @NotBlank(message = "Attributes should not be empty or null")
    @Size(max = 20, message = "Attributes maximum size 20 character")
    private String attributes;

    @NotBlank(message = "Subject id should not be empty or null")
    private String subjectId;

    @NotBlank(message = "Exception message should not be empty or null")
    @Size(max = 50, message = "Exception maximum size 50 character")
    private String exceptionMessage;

    @NotBlank(message = "Message type should not be empty or null")
    @Size(max = 20, message = "Message type maximum size 20 character")
    private String messageType;

    @NotBlank(message = "External patient id should not be empty or null")
    private String externalPatientId;

    @NotBlank(message = "Portal consumer id should not be empty or null")
    private int portalConsumerId;

    @NotBlank(message = "External provider id should not be empty or null")
    private String externalProviderId;

    @NotBlank(message = "Portal staff id should not be empty or null")
    private int portalStaffId;

    @NotBlank(message = "External message id should not be empty or null")
    private String externalMessageId;

    @NotBlank(message = "Revision should not be empty or null")
    private Integer revision;

    @NotBlank(message = "Error cd should not be empty or null")
    @Size(max = 20, message = "Error cd maximum size 20 character")
    private String errorCd;

    @NotBlank(message = "Error description should not be empty or null")
    @Size(max = 50, message = "Error description maximum size 20 character")
    private String errorDescription;

    @NotBlank(message = "Error severity should not be empty or null")
    @Size(max = 10, message = "Error severity maximum size 10 character")
    private String errorSeverity;

    private ProcessingStatusType processingStatusType;
}
