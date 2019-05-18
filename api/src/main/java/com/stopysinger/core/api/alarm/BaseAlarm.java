package com.stopysinger.core.api.alarm;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BaseAlarm {
    private String status;

    public BaseAlarm(String status) {
        this.status = status;
    }
}
