package com.sebas.restful.students;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@RequestMapping(value = "/")
	public String sayHelloWorld() {
		System.out.println("[" + LocalDateTime.now() + "]" + " RESTFul students Server. The application is currently running...");
		return "[" + LocalDateTime.now() + "]" + " RESTFul students Server. The application is currently running...";
	}

}
