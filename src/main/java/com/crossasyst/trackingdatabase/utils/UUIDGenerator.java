package com.crossasyst.trackingdatabase.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UUIDGenerator {

    UUID uuid = UUID.randomUUID();
    private String dataJobGuid = uuid.toString();

}
