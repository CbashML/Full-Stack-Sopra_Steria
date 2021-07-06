package com.sebas.ejerciciosjpa.cap3.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;

import com.sebas.ejerciciosjpa.cap3.embeddable.Manager;
import com.sebas.ejerciciosjpa.cap3.entities.Department;
import com.sebas.ejerciciosjpa.cap3.entities.Employee;

public class ServiceEmployee {

	public Employee createEmployeeWithDepartment(EntityManager em, String firstName, String lastName,
			String email, String phoneNumber, String jobId, String hireDate, long salary, Department department, long managerId) {
		
		String pattern = "yyyy-MM-dd"; 
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern); 
		Date hD=null;
		try {
			hD = simpleDateFormat.parse(hireDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Employee emp = new Employee(firstName, lastName, email, phoneNumber, jobId, hD, salary, department, new Manager(managerId));
		try {
			em.persist(emp);
		} catch (Exception e) {
			System.out.println("||Exception|| " + e.getMessage());
			System.out.println(emp.toString());
			return null;
		}
		return emp;
	}
	
	public Employee findEmployeeById(EntityManager em, long id) {
		return em.find(Employee.class, id);
	}
}
