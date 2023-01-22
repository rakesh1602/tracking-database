package com.crossasyst.trackingdatabase.model;


import com.example.onetoone.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {

    @NotBlank(message = "Activity name should not be empty or null")
    @Size(max = 20, message = "Activity name maximum size 20 character")
    private String activityName;

    private Date processingStartDt;

    private Date processingEndDt;

    @NotBlank(message = "Revision should not be empty or null")
    private Integer revision;

    Person person=new Person();


}
