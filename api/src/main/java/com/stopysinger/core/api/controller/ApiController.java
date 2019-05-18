package com.stopysinger.core.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stopysinger.core.api.Haversine;
import com.stopysinger.core.api.alarm.BaseAlarm;
import com.stopysinger.core.api.bean.RequestPoint;
import com.stopysinger.core.api.bean.WayPoint;
import com.stopysinger.core.api.model.Point;
import com.stopysinger.core.api.model.Route;
import com.stopysinger.core.api.repository.RoutesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {
    private static double MIN_DISTANCE_FOR_ALARM = 2.0;

    @Autowired
    private RoutesRepository routesRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/routes", method = RequestMethod.GET)
    public ResponseEntity<List<WayPoint>> getRoute(@RequestParam(value="id") String name) {
        List<Point> points = routesRepository.getPoints(name);
        List<WayPoint> dePoints = new ArrayList<>();
        for(Point point : points) {
            List pointList = new ArrayList();
            pointList.add(point.getY());
            pointList.add(point.getX());
            WayPoint viaPoint = new WayPoint(pointList);
            dePoints.add(viaPoint);
        }
        return new ResponseEntity<>(dePoints, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/routes", method = RequestMethod.POST)
    public void createRoute(@RequestParam(value="id") String name) {
        Route route = new Route();
        route.setName(name);
        routesRepository.save(route);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/point", method = RequestMethod.POST)
    public ResponseEntity<BaseAlarm> trackPoint(@RequestBody RequestPoint requestPoint) {
        Route route = routesRepository.findByName(requestPoint.getId());
        List<Point> points = route.getPoints();

        Double issueLon = requestPoint.getLon();
        Double issueLat = requestPoint.getLat();

        Point startPoint = points.get(0);

        Double issueDistance = Haversine.distance(issueLat, issueLon, startPoint.getX(), startPoint.getY());

        for(Point point : points) {
            Double nextDistance = Haversine.distance(issueLat, issueLon, point.getX(), point.getY());
            if (issueDistance > nextDistance) {
                issueDistance = nextDistance;
            }
        }

        if (MIN_DISTANCE_FOR_ALARM >= issueDistance) {
            return new ResponseEntity<>(new BaseAlarm("alarm"), HttpStatus.OK);
        }

        return new ResponseEntity<>(new BaseAlarm("close"), HttpStatus.OK);
    }

    @RequestMapping(value = "/all_routes", method = RequestMethod.GET)
    public String getAllRoutes() throws JsonProcessingException {
        List<String> routes = routesRepository.getNames();
        return objectMapper.writeValueAsString(routes);
    }
}
