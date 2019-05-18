package com.stopysinger.core.api.repository;

import com.stopysinger.core.api.model.CheckPoint;
import com.stopysinger.core.api.model.Point;
import com.stopysinger.core.api.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckPointRepository extends JpaRepository<CheckPoint, Long> {
    @Query("select rt.points from Route rt where rt.name=:name")
    List<Point> getPoints(String name);
}
