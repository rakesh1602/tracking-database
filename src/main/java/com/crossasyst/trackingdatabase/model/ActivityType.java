package com.crossasyst.trackingdatabase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityType {


    @NotBlank(message = "Description should not be empty or null")
    @Size(max =50, message = "Description maximum size 50 character")
    private String description;

    @NotBlank(message = "ActiveBit should not be empty or null")
    @Size(max = 10, message = "ActiveBit maximum size 10 character")
    private Integer activeBit;

    /*private List<Activity> activity;*/
}
