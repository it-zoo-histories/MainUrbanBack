package com.stopysinger.core.api.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "checkPoint")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CheckPoint {

    public CheckPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public CheckPoint() {}

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
