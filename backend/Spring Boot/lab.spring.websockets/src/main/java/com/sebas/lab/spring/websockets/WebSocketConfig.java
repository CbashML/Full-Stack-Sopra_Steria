package com.sebas.lab.spring.websockets;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
    	//Donde se van a mandar los mensajes p.e /topic/verbose que será como un echo, 
    	//todos los mensajes se enviaran a topic, en js te suscribes a /topic/verbose.
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");//
    }
    

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/thedfa-communicationshub").withSockJS();
    }
}