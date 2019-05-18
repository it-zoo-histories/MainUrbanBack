package com.stopysinger.core.api.bean;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ViaPoint {
    private String type;
    private List<Double> point;

    public ViaPoint(String type, List<Double> point) {
        this.type = type;
        this.point = point;
    }
}
