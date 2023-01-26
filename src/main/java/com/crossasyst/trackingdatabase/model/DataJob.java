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
public class DataJob extends Base {

    @NotBlank(message = "Job description should not be empty or null")
    @Size(max = 50, message = "Job description maximum size 50 character")
    private String jobDirection;

    @NotBlank(message = "Data job Guid should not be empty or null")
    @Size(max = 10, message = "Data job Guid maximum size 10 character")
    private String dataJobGuid;

    @NotBlank(message = "Input file name should not be empty or null")
    @Size(max = 15, message = "Input file name maximum size 15 character")
    private String inputFileName;

    private LocalDateTime processingStartDt;

    private LocalDateTime processingEndDt;

    @NotBlank(message = "Data feed should not be empty or null")
    @Size(max = 10, message = "Data feed maximum size 10 character")
    private String dataFeed;

    @NotBlank(message = "Data source should not be empty or null")
    @Size(max = 15, message = "Data source maximum size 15 character")
    private String dataSource;

    @NotBlank(message = "Data should not be empty or null")
    @Size(max = 50, message = "Description maximum size 50 character")
    private String dataPartner;

    @NotBlank(message = "Message type should not be empty or null")
    @Size(max = 20, message = "Message type maximum size 20 character")
    private String msgType;

    @NotBlank(message = "Job type should not be empty or null")
    @Size(max = 10, message = "Description maximum size 10 character")
    private String jobType;

    @NotBlank(message = "External system name should not be empty or null")
    @Size(max = 15, message = "External system name maximum size 15 character")
    private String externalSystemName;

    private Long orgId;

    private String orgUuid;

    private DataChannel dataChannel;

    private JobStatusType jobStatusType;
}
