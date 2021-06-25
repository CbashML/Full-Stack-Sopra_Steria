package com.example.mod2lab2.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.example.mod2lab2.model.Student;

public class RESTConsumerService {
	
	private final static String __TargetURL = "http://localhost:8080/";
    private final static String __TargetURL_RelativePath = "students";

    @Autowired
    RestTemplate restTemplate;
    
    @Autowired
    private RESTConsumerService restConsumerService;
    
  //@RequestMapping(value = "/students")
    public Student[] getAll() 
    {
        HttpHeaders headers;
        HttpEntity<Student> entity;

        headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        entity = new HttpEntity<Student>(headers);
        return restTemplate.exchange(__TargetURL + __TargetURL_RelativePath, 
                                     HttpMethod.GET,  
                                     entity, Student[].class).getBody();
    }
    
    //@RequestMapping(value="/students", method=RequestMethod.POST)
    public Student create(Student student) 
    {
        HttpHeaders headers;
        HttpEntity<Student> entity;
        
        String id = String.valueOf(restConsumerService.getAll().length + 1);
		student.setId(id);
        
        headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        entity = new HttpEntity<Student>(student, headers);
        return restTemplate.exchange(__TargetURL + __TargetURL_RelativePath, 
                                     HttpMethod.POST, 
                                     entity, 
                                     Student.class).getBody();
    }
    
    public Student findByEmail(String email)
    {
        if (email != null &&
            email.length() > 0)
        {
            for(Student student : getAll())
            {
                if (student.getEmail() != null &&
                    student.getEmail().equals(email))
                    return student;
            }
        }

        return null;
    }

}
