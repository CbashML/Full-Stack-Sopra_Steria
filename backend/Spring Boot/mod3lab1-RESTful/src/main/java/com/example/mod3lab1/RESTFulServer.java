package com.example.mod3lab1;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RESTFulServer {

	public static void main(String[] args) {
		SpringApplication.run(RESTFulServer.class, args);
	}

	@RequestMapping(value = "/")
	public String sayHelloWorld() {
		return "[" + LocalDateTime.now() + "]" + HTMLUtilities.Entities.__NonBreakingSpace + HTMLUtilities.Entities.__NonBreakingSpace
				+ HTMLUtilities.Entities.__NonBreakingSpace + " RESTFul Server. The application is currently running...";
	}
}
