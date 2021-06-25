package com.example.mod4lab1.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.example.mod4lab1.model.Student;

public class RESTConsumerService 
{

    private final static String __TargetURL = "http://localhost:8080/";
    private final static String __TargetURL_RelativePath = "students";

    @Autowired
    RestTemplate restTemplate;

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

        headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        entity = new HttpEntity<Student>(student, headers);
        return restTemplate.exchange(__TargetURL + __TargetURL_RelativePath, 
                                     HttpMethod.POST, 
                                     entity, 
                                     Student.class).getBody();
    }

    //@RequestMapping(value="/students/{id}", method=RequestMethod.PUT)
    public Student update(String id, Student student) 
    {
        HttpHeaders headers;
        HttpEntity<Student> entity;

        headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        entity = new HttpEntity<Student>(student, headers);
        return restTemplate.exchange(__TargetURL + __TargetURL_RelativePath + "/" + id, 
                                     HttpMethod.PUT, 
                                     entity, 
                                     Student.class).getBody();
    }

    //@RequestMapping(value="/students/{id}", method=RequestMethod.DELETE)
    public Student delete(String id) 
    {
        HttpHeaders headers;
        HttpEntity<Student> entity;

        headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        entity = new HttpEntity<Student>(headers);
        return restTemplate.exchange(__TargetURL + __TargetURL_RelativePath + "/" + id, 
                                     HttpMethod.DELETE, 
                                     entity, 
                                     Student.class).getBody();
    }

}
