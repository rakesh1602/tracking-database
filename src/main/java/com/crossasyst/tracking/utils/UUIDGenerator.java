package com.crossasyst.tracking.utils;

import lombok.Data;

import java.util.UUID;

@Data
public class UUIDGenerator {

    public String generateUUID() {
        return UUID.randomUUID().toString();
    }
}
