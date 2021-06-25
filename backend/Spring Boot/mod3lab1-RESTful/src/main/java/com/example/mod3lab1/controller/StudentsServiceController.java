package com.example.mod3lab1.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mod3lab1.model.Student;

@RestController
public class StudentsServiceController {

    private static final String __ControllerRelativePath = "students";
    private static Map<String, Student> repo = new HashMap<>();
    
    static {

        Student student;
        
        student = new Student();
        student.setId("1");
        student.setName("Student 1");
        student.setEmail("student1@example.com");
        student.setPassword("Student1");
        repo.put(student.getId(), student);
    
        student = new Student();
        student.setId("2");
        student.setName("Student 2");
        student.setEmail("student2@example.com");
        student.setPassword("Student2");
        repo.put(student.getId(), student);

        student = new Student();
        student.setId("3");
        student.setName("Student 3");
        student.setEmail("student3@example.com");
        student.setPassword("Student3");
        repo.put(student.getId(), student);

        student = new Student();
        student.setId("4");
        student.setName("Student 4");
        student.setEmail("student4@example.com");
        student.setPassword("Student4");
        repo.put(student.getId(), student);

        student = new Student();
        student.setId("5");
        student.setName("Student 5");
        student.setEmail("student5@example.com");
        student.setPassword("Student5");
        repo.put(student.getId(), student);
    }
    
    @GetMapping(value="/" + __ControllerRelativePath + "/getById")
    public ResponseEntity<Student> getById(@RequestParam(required = true) String id) { 
        return new ResponseEntity<Student>(repo.get(id), HttpStatus.OK);
    }
    
    @GetMapping(value="/" + __ControllerRelativePath + "/getByEmail")
    public ResponseEntity<Student> getByEmail(@RequestParam(required = true) String email) { 
       String id = "0";
       for (int i = 0; i < repo.size(); i++) {
    	   String key = String.valueOf(i + 1);
    	   if (repo.get(key).getEmail() == email) 
    		   id = key;
       }
    	return new ResponseEntity<Student>(repo.get(id), HttpStatus.OK);
    }

    @RequestMapping(value="/" + __ControllerRelativePath)
    @CrossOrigin(origins = { "http://localhost:8080", "http://localhost:9090"})
    public ResponseEntity<Collection<Student>> getAll() { 
        return new ResponseEntity<Collection<Student>>(repo.values(), HttpStatus.OK);
    }
    @RequestMapping(value="/" + __ControllerRelativePath, method=RequestMethod.POST)
    public ResponseEntity<Student> create(@RequestBody Student student) {
        repo.put(student.getId(), student);
        return new ResponseEntity<Student>(student, HttpStatus.CREATED);
    }
    @RequestMapping(value="/" + __ControllerRelativePath + "/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Student> update(@PathVariable("id") String id, @RequestBody Student student) {
        student.setId(id);
        repo.put(id, student);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }
    @RequestMapping(value="/" + __ControllerRelativePath + "/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Student> delete(@PathVariable("id") String id) {
        return new ResponseEntity<Student>(repo.remove(id), HttpStatus.OK);
    }
}