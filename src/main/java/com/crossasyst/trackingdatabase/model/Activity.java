package com.crossasyst.trackingdatabase.model;

import com.crossasyst.trackingdatabase.model.base.Base;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class Activity extends Base {

    @NotBlank(message = "Activity name should not be empty or null")
    @Size(max = 20, message = "Activity name maximum size 20 character")
    private String activityName;

    private LocalDateTime processingStartDate;

    private LocalDateTime processingEndDate;

    @NotNull(message = "Revision should not be empty or null")
    private Integer revision;

    private Message message;

    private ActivityType activityType;

    private ProcessingStatusType processingStatusType;
}
