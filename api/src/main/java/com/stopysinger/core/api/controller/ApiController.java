package com.stopysinger.core.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stopysinger.core.api.bean.BaseMapPoint;
import com.stopysinger.core.api.bean.ViaPoint;
import com.stopysinger.core.api.bean.WayPoint;
import com.stopysinger.core.api.model.Point;
import com.stopysinger.core.api.model.Route;
import com.stopysinger.core.api.repository.RoutesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private RoutesRepository routesRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(value = "/routes", method = RequestMethod.GET)
    public String getRoute(@RequestParam(value="id") String name) throws JsonProcessingException {
        List<Point> points = routesRepository.getPoints(name);
        List<WayPoint> dePoints = new ArrayList<>();
        for(Point point : points) {
            List pointList = new ArrayList();
            pointList.add(point.getY());
            pointList.add(point.getX());
            WayPoint viaPoint = new WayPoint(pointList);
            dePoints.add(viaPoint);
        }
        return objectMapper.writeValueAsString(dePoints);
    }

    @RequestMapping(value = "/routes", method = RequestMethod.POST)
    public void createRoute(@RequestParam(value="id") String name) {
        Route route = new Route();
        route.setName(name);
        routesRepository.save(route);
    }

    @RequestMapping(value = "/point", method = RequestMethod.POST)
    public void trackPoint(@RequestParam(value="id") String name,
                           @RequestParam(value="x") String x,
                           @RequestParam(value="y") String y) {
        Route route = routesRepository.findByName(name);
        route.getPoints().add(new Point(Double.parseDouble(x), Double.parseDouble(y)));
        routesRepository.save(route);
    }

    @RequestMapping(value = "/all_routes", method = RequestMethod.GET)
    public String getAllRoutes() throws JsonProcessingException {
        List<String> routes = routesRepository.getNames();
        return objectMapper.writeValueAsString(routes);
    }
}
