package com.stopysinger.core.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stopysinger.core.api.bean.ViaPoint;
import com.stopysinger.core.api.model.Point;
import com.stopysinger.core.api.repository.RoutesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {

    @Autowired
    RoutesRepository routesRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(value = "/routes", method = RequestMethod.GET)
    public String getRoute(@RequestParam(value="id") String id) throws JsonProcessingException {
        List<Point> points = routesRepository.getPoints(id);
        List<ViaPoint> dePoints = new ArrayList<>();
        for(Point point : points) {
            List pointList = new ArrayList();
            pointList.add(point.getX());
            pointList.add(point.getY());
            ViaPoint viaPoint = new ViaPoint("viaPoint", pointList);
            dePoints.add(viaPoint);
        }
        return objectMapper.writeValueAsString(dePoints);
    }

    @RequestMapping(value = "/all_routes", method = RequestMethod.GET)
    public String getAllRoutes() throws JsonProcessingException {
        List<String> routes = routesRepository.getNames();
        return objectMapper.writeValueAsString(routes);
    }
}
