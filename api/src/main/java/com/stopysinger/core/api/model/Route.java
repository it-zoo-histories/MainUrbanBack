package com.stopysinger.core.api.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToMany
    private List<Point> points;
    private String name;
}
