package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

@Controller
public class controller {

    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public controller(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String hello() {
        return "hi";
    }

    @MessageMapping("/messages")
    @SendToUser("/queue/messages")
    public String message(@Payload String message) {
        System.out.println(message);
        return message;
    }
}
