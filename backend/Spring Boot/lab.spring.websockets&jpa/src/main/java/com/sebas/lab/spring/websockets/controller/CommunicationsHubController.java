package com.sebas.lab.spring.websockets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import com.sebas.lab.spring.websockets.domain.InboundMessage;
import com.sebas.lab.spring.websockets.domain.OutboundMessage;
import com.sebas.lab.spring.websockets.service.CommunicationsHubService;

@Controller
public class CommunicationsHubController {

	@Autowired
	private CommunicationsHubService communicationService;
	
	
    /**Manda el mensaje entrante a todos los usuarios subscritos a /topic/verbose
     * @param message
     * @return OutboundMessage
     */
    @MessageMapping("/send")
    @SendTo("/topic/verbose")
    public OutboundMessage send(InboundMessage message) throws Exception {
        return communicationService.send(message);
    }
    
    
//    @MessageMapping("/getAllMessages")
//    @SendTo("/topic/verbose")
    /** Devuelve todos los mensajes al usuario subscrito.
     * @return List<OutboundMessage>
     */
    @SubscribeMapping("/verbose")
    public List<OutboundMessage> getAll() throws Exception {
    	return communicationService.getAll();
    }

}   