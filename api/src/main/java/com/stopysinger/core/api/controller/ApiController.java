package com.stopysinger.core.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stopysinger.core.api.model.Point;
import com.stopysinger.core.api.repository.RoutesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    RoutesRepository routesRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping("/routes")
    public String greeting(@RequestParam(value="id") String id) throws JsonProcessingException {
        List<Point> points = routesRepository.getPoints(id);
        return objectMapper.writeValueAsString(points);
    }
}
