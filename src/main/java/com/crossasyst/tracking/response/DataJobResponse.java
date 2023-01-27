package com.crossasyst.tracking.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataJobResponse {

    private Long dataJobID;

    private String dataJobGuid;
}
