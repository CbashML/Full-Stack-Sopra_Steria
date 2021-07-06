package com.sebas.lab.spring.websockets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebas.lab.spring.websockets.domain.InboundMessage;
import com.sebas.lab.spring.websockets.domain.OutboundMessage;
import com.sebas.lab.spring.websockets.repository.OutMessageRepository;

@Service
public class CommunicationsHubService {
	
	@Autowired
	private OutMessageRepository outMsgRepo;
	
	 public OutboundMessage send(InboundMessage message) throws Exception {
	        Thread.sleep(1000); // simulated delay
	        outMsgRepo.save(new OutboundMessage(message.getContent()));
	        return new OutboundMessage(message.getContent());
	    }
	
	public List<OutboundMessage> getAll() throws Exception {
		List<OutboundMessage> list = outMsgRepo.findAll();
		return list;
	}
}
