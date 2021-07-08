package com.sebas.restful.students.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebas.restful.students.entity.Student;
import com.sebas.restful.students.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	public List<Student> getAllStudents(){
		List<Student> students = studentRepo.findAll();
		for (Student student : students)
			System.out.println(student);
		return students;
	}
	
	public Optional<Student> getStudentById(long id) {
		return studentRepo.findById(id);
	}
	
	public Student updateStudent(Student student){
		Student studentToUpdate = studentRepo.findById(student.getId()).get();
		studentToUpdate.setName(student.getName());
		studentRepo.save(studentToUpdate);
		return studentToUpdate;
	}
	
	public Student deleteStudentById(long id){
		Student student = studentRepo.findById(id).get();
		try {
			studentRepo.deleteById(id);
			return student;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public Student createStudent(Student student) {
		Student newStudent;
		System.out.println("//::TRACE:: Creating new student//");
		System.out.println(student);
		if (student.getEmail() == null)
			student.setEmail("foo@wihtout-email.com");
		if (student.getPassword() == null)
			student.setPassword("Created without password for test.");
		newStudent = new Student(student.getName(), student.getEmail(), student.getPassword());
		System.out.println("//::TRACE:: New student created//");
		System.out.println(newStudent);
		newStudent = studentRepo.save(newStudent);
		System.out.println(newStudent);
		return newStudent;
	}
	
	public List<Student> searchStudentByNameLike(String name){
		System.out.println("//::TRACE::signature:searchStudentByNameLike(String name)//");
		System.out.println("TRACE NAME: |" + name + "|");
		List<Student> students = studentRepo.findByNameLike(name);
		System.out.println("TRACE List<Student> :" + students);
		for (Student student : students) 
			System.out.println(student);
		return students;
	}
	
}
