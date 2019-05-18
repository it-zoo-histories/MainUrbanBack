package com.stopysinger.core.api.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
public class ApiWayPointController {

//    @CrossOrigin("*")
    @MessageMapping("/chat")
    @SendTo("/topic/test")
    public String greeting(String message) throws Exception {
        Thread.sleep(1000);
        return "from websocket";
    }
}
