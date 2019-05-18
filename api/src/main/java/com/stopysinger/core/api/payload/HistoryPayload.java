package com.stopysinger.core.api.payload;

import com.stopysinger.core.api.model.Route;

import java.util.*;

public class HistoryPayload {
    private long userId;
    private List<Route> routes;


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }
}
