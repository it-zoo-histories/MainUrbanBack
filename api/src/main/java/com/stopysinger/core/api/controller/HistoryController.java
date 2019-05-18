package com.stopysinger.core.api.controller;

import com.stopysinger.core.api.model.History;
import com.stopysinger.core.api.model.Route;
import com.stopysinger.core.api.payload.HistoryPayload;
import com.stopysinger.core.api.repository.HistoryRepository;
import com.stopysinger.core.api.repository.RoutesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class HistoryController {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private RoutesRepository routesRepository;

    private final static String API = "/history";

    @RequestMapping(value = API, method = RequestMethod.GET)
    public HistoryPayload getHistory(@RequestParam("user_id") long userId) {
        final History history = historyRepository.findByUserId(userId).get();
        final HistoryPayload payload = new HistoryPayload();
        payload.setUserId(userId);
        payload.setRoutes(history.getRoutes());
        return payload;
    }

    @RequestMapping(value = API, method = RequestMethod.POST)
    public String createHistory(@RequestBody HistoryPayload payload) {
//        final Route route = routesRepository.findByName(payload.getName());
//        final History history = historyRepository.findByUserId(payload.getUserId()).get();
//        history.getRoutes().add(route);
//        historyRepository.save(history);
        return "Success";
    }
}
