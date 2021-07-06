package com.sebas.lab.spring.websockets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebas.lab.spring.websockets.domain.InboundMessage;
import com.sebas.lab.spring.websockets.domain.OutboundMessage;
import com.sebas.lab.spring.websockets.repository.OutMessageRepository;

/**
 * @author semolina
 *
 */
@Service
public class CommunicationsHubService {

	@Autowired
	private OutMessageRepository outMsgRepo;

	/**
	 * Devuelve el mensaje entrante y los guarda/persiste en la base de datos.
	 * 
	 * @param message
	 *            obtenido/recibido desde desde una función del controlador, quien
	 *            nos proporciona el mensaje.
	 * @return OutboundMessage mensaje que obtiene la función desde el controlador
	 *         como respuesta.
	 */
	public OutboundMessage send(InboundMessage message) throws Exception {
		Thread.sleep(1000); // simulated delay
		outMsgRepo.save(new OutboundMessage(message.getContent()));
		return new OutboundMessage(message.getContent());
	}

	/**
	 * Devuelve una lista de mensajes.
	 * 
	 * @return List<OutboundMessage>	lista de mensajes que obtiene como respuesta la función que ha hecho llamada desde el controlador.
	 */
	public List<OutboundMessage> getAll() throws Exception {
		List<OutboundMessage> list = outMsgRepo.findAll();
		return list;
	}
}
