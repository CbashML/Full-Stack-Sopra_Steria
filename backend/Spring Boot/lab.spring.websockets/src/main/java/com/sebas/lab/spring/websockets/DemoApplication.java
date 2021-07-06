package com.sebas.lab.spring.websockets;

import java.time.LocalDateTime;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sebas.lab.spring.websockets.utilities.HTMLUtilities;

@SpringBootApplication
public class DemoApplication implements ApplicationRunner
{
	public static void main(String[] args) {
		say("WebSockets Application. Starting...");
		SpringApplication.run(DemoApplication.class, args);
		say(" WebSockets Application. Running...");
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		say(" Websockets Application. The application is currently running...");
	}

	public static String say(String message) {
		return "[" + LocalDateTime.now() + "]" 
				+ HTMLUtilities.Entities.__NonBreakingSpace
				+ HTMLUtilities.Entities.__NonBreakingSpace
				+ HTMLUtilities.Entities.__NonBreakingSpace
				+ message;
	}
}                            
