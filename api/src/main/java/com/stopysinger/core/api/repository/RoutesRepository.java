package com.stopysinger.core.api.repository;

import com.stopysinger.core.api.model.Point;
import com.stopysinger.core.api.model.Route;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoutesRepository extends CrudRepository<Long, Route> {
    @Query("select rt.points from Route rt where rt.name=:name")
    List<Point> getPoints(String name);
}
