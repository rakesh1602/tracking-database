package com.crossasyst.trackingdatabase.model.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Base {

    private LocalDateTime createdTs;

    @NotNull(message = "Activity name should not be empty or null")
    private Long createdBy;

    private LocalDateTime updatedTs;

    @NotNull(message = "Activity name should not be empty or null")
    private Long updatedBy;
}
