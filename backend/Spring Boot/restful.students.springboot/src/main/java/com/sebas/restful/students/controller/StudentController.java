package com.sebas.restful.students.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sebas.restful.students.entity.Student;
import com.sebas.restful.students.service.StudentService;

@RestController
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:4200"})
public class StudentController {

	private static final String RelativePath = "/v1/api/students";
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value = RelativePath)
	@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:4200"})
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@GetMapping(value = (RelativePath + "/{id}"))
	public Optional<Student> getStudentById(@PathVariable("id") long id){
		return studentService.getStudentById(id);
	}
	
	@PutMapping(value = RelativePath)
	public Student updateStudent(@RequestBody Student student){
		return studentService.updateStudent(student);
	}
	
	@DeleteMapping(value = (RelativePath + "/{id}"))
	public Student deleteStudentById(@PathVariable("id") long id){
		return studentService.deleteStudentById(id);
	}
	
	@PostMapping(value = RelativePath)
	public Student createStudent(@RequestBody Student student){
		return studentService.createStudent(student);
	}
	
	@GetMapping(value = RelativePath + "/")
	@ResponseBody
	public List<Student> searchStudentsByNameLike(@RequestParam(required = true, defaultValue = "") String name){
		System.out.println("TRACE NAME: |" + name + "|");
		return studentService.searchStudentByNameLike(name);
	}
	
}
