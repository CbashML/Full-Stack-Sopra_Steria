package com.sebas.lab.spring.websockets;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
//import org.springframework.web.socket.messaging.SessionSubscribeEvent;
//import org.springframework.messaging.simp.SimpMessageSendingOperations;
//import com.example.ChatApp2.classes.InboundMessage;
//import com.example.ChatApp2.classes.OutboundMessage;

@Component
public class SocketEvents {
    
    //@Autowired
    // private SimpMessageSendingOperations msgTemplate;
    
    @EventListener
    private void hanleSessionConnected(SessionConnectEvent event) {
        StompHeaderAccessor headers = StompHeaderAccessor.wrap(event.getMessage());
        System.out.println("User connected! Session Id: " + headers.getSessionId());
    }

    /*@EventListener
    private void handleSubscription(SessionSubscribeEvent event) {
        System.out.println("Susbcrito!");
        msgTemplate.convertAndSend("/topic/verbose", new OutboundMessage ("Welcome to the server!"));
    }
    */
}