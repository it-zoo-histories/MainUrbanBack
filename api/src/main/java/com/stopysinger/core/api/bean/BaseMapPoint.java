package com.stopysinger.core.api.bean;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BaseMapPoint {
    private List<Double> point;

    public BaseMapPoint(List<Double> point) {
        this.point = point;
    }
}
