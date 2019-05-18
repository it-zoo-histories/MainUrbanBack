package com.stopysinger.core.api.bean;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class WayPoint extends BaseMapPoint {
    private String type = "wayPoint";

    public WayPoint(List<Double> point) {
        super(point);
    }
}
