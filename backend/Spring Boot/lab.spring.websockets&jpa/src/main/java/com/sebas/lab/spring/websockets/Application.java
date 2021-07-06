package com.sebas.lab.spring.websockets;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sebas.lab.spring.websockets.domain.OutboundMessage;
import com.sebas.lab.spring.websockets.repository.OutMessageRepository;
import com.sebas.lab.spring.websockets.utilities.HTMLUtilities;

@SpringBootApplication
public class Application implements ApplicationRunner
{
	
	@Autowired
	private OutMessageRepository outMsgRepo;
	
	public static void main(String[] args) {
		System.out.println(say("WebSockets chat Application. Starting..."));
		SpringApplication.run(Application.class, args);
		System.out.println(say(" WebSockets chat Application. Running..."));
	}

	/* (non-Javadoc)
	 * @see org.springframework.boot.ApplicationRunner#run(org.springframework.boot.ApplicationArguments)
	 */
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(say(" Websockets chat Application. The application is currently running..."));
	}

	public static String say(String message) {
		return "[" + LocalDateTime.now() + "]" 
				+ HTMLUtilities.Entities.__NonBreakingSpace
				+ HTMLUtilities.Entities.__NonBreakingSpace
				+ HTMLUtilities.Entities.__NonBreakingSpace
				+ message;
	}
	
	/**
	 * Generar los primeros mensajes en la base de datos
	 * entre ellos el primero es el saludo con id = 1L.
	 */
	@Bean
	CommandLineRunner runner() {
		return args -> {
			// Save demo message data to database
			outMsgRepo.save(new OutboundMessage("Welcome to basic hello world chat!", "Server"));
			outMsgRepo.save(new OutboundMessage("Test message 1!", "Server"));
			outMsgRepo.save(new OutboundMessage("Test message 2!", "Server"));
		};
	}
	
}                            
