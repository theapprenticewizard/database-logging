package com.theapprenticewizard.databaselogging.application;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Log {
    private String id;
    private long timestamp = LocalDateTime.now().getNano();
    private Object loggable;
}
