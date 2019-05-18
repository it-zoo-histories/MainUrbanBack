package com.stopysinger.core.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "routes")
public class Route {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToMany
    @JsonIgnore
    private List<Point> points;
    private String name;
}
