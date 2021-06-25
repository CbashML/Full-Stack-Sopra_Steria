package com.example.mod4lab1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.mod4lab1.model.Student;
import com.example.mod4lab1.service.RESTConsumerService;

@SpringBootApplication
public class RESTConsumerApplication implements CommandLineRunner, ApplicationRunner {

	private final static String targetURL = "http://localhost:8080/students";

	@Autowired
	private RESTConsumerService restConsumerService;

	public static void main(String[] args) {
		SpringApplication.run(RESTConsumerApplication.class, args);

		System.out.println("RESTConsumerApplication. Ended.");
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public RESTConsumerService getService() {
		return new RESTConsumerService();
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("RESTConsumerApplication. CommandLineRunner...");

		Student[] whenBeginingTest;
		Student[] whenDeletingIsFinished;
		Student[] updatingStudent;
		Student[] atTheEnd;
		
		System.out.println("*** STUDENTS SET MANIPULATION STARTED ***");

		whenBeginingTest = restConsumerService.getAll();

		System.out.println("*** " + whenBeginingTest.length + " ***");
		for (Student student : whenBeginingTest) {
			System.out.println(student.getName());
		}
		System.out.println("*** " + "*" + "***");

		System.out.println("***** DELETE ******");
		for (Student student : whenBeginingTest) {
			System.out.println("Deleting... [" + student.getName() + "].");
			Student deleted = restConsumerService.delete(student.getId());
			if (deleted != null)
				System.out.println("Deleted!");
		}

		whenDeletingIsFinished = restConsumerService.getAll();

		System.out.println("*** " + whenDeletingIsFinished.length + " ***");
		for (Student student : whenDeletingIsFinished) {
			System.out.println(student.getName());
		}
		System.out.println("*** " + "*" + "***");

		System.out.println("***** CREATE *****");
		
		for (Student student : whenBeginingTest) {
			System.out.println("Creating... [" + student.getName() + "].");
			Student created = restConsumerService.create(student);
			if (created != null)
				System.out.println("Created!");
		}

        for (Student student : whenBeginingTest) {
            System.out.println("Creating... [" + student.getName() + "].");
            Student created = restConsumerService.create(student);
            if (created != null)
                System.out.println("Created!");
        }
        
            
        System.out.println("*** UPDATE ***");
        updatingStudent = restConsumerService.getAll();
        
        System.out.println("Updating... [" + updatingStudent[1].getName() + "].");
        Student newStudent = new Student();
        newStudent.setName("Nombre Nuevo, Apellido Nuevo");
        
        Student modified = restConsumerService.update(updatingStudent[1].getId(), newStudent);
        if (modified != null) {
            System.out.println("Modified from ["+updatingStudent[1].getName() +"] to [" + modified.getName()+"]");
        }
        
        Student[] whenUpdated = restConsumerService.getAll();
        System.out.println("**** STUDENTS ****");
        for (Student student : whenUpdated) {
            System.out.println(student.getName());
        }
        
        System.out.println("**** UNDO ****");
        Student modifiedUndo = restConsumerService.update(updatingStudent[1].getId(), updatingStudent[1]);
        if (modified != null) {
            System.out.println("Undo from ["+modified.getName() +"] to [" + modifiedUndo.getName()+"]");
        }
		
		System.out.println("***** At The End *****");
		
		atTheEnd = restConsumerService.getAll();

		System.out.println("*** " + atTheEnd.length + " ***");
		for (Student student : atTheEnd) {
			System.out.println(student.getName());
		}
		System.out.println("*** " + "*" + "***");

		System.out.println("*** STUDENTS SET MANIPULATION ENDED ***");
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		System.out.println("RESTConsumerApplication. ApplicationRunner...");

		HttpEntity<Student> entity;
//		ResponseEntity response;
		ResponseEntity<Student[]> response;
		HttpHeaders headers;
		RestTemplate restTemplate;

		restTemplate = new RestTemplate();
		
		headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		entity = new HttpEntity<Student>(headers);

		response = restTemplate.exchange(targetURL, HttpMethod.GET, entity, Student[].class);
		

		if (response.getStatusCode() == HttpStatus.OK) {
			System.out.println(response);

			for (Student student : response.getBody()) {
				System.out.println(student.getName());
			}
		} else
			System.out.println("RESTConsumerApplication. Error [" + response.getStatusCode() + "].");
	}
}                         