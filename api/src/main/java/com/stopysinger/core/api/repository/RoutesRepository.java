package com.stopysinger.core.api.repository;

import com.stopysinger.core.api.model.Point;
import com.stopysinger.core.api.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoutesRepository extends JpaRepository<Route, Long> {
    @Query("select rt.points from Route rt where rt.name=:name")
    List<Point> getPoints(String name);

    @Query("select rt.name from Route rt")
    List<String> getNames();

    @Query("select rt from Route rt where rt.name=:name")
    Route findByName(String name);
}
