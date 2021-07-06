package com.sebas.ejerciciosjpa.cap3.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sebas.ejerciciosjpa.cap3.entities.Department;
import com.sebas.ejerciciosjpa.cap3.entities.Employee;
import com.sebas.ejerciciosjpa.cap3.services.ServiceDepartment;
import com.sebas.ejerciciosjpa.cap3.services.ServiceEmployee;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EjerciciosJPA-Cap3-ORM");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		Department department = createDepartment(em, new ServiceDepartment(), 114L);
		createEmployeeWithDepartment(em, new ServiceEmployee(), department, 100L);
		em.getTransaction().commit();
		findEmployeeById(em, new ServiceEmployee());

		em.close();
		emf.close();
	}

	private static Employee createEmployeeWithDepartment(EntityManager em, ServiceEmployee serviceEmployee,
			Department department, long managerId) {
		System.out.println(
				"\nsignature::Employee createEmployeeWithDepartmentWithoutManagerEitherLocation(EntityManager em,\r\n"
						+ "			ServiceEmployee serviceEmployee, Department department, long managerId)::");
		Employee employee = serviceEmployee.createEmployeeWithDepartment(em, "firstName", "lastName",
				"foo4@example.com", "55555333", "IT_PROG", "12-12-12", 121212L, department, managerId);
		System.out.println("Se ha creado el empelado -> " + employee.toString());
		return employee;
	}

	private static Department createDepartment(EntityManager em, ServiceDepartment serviceDepartment, long managerId) {
		System.out.println("\nsignature::createDepartment(EntityManager em, ServiceDepartment s, long managerId)::");
		Department department = serviceDepartment.createDepartment(em, "New Department", managerId);
		System.out.println("Se ha creado el departamento -> " + department.toString());
		return department;
	}

	private static void findEmployeeById(EntityManager em, ServiceEmployee s) {
		System.out.println("signature::findEmployeeById(EntityManager em, ServiceEmployee s)::");
		Employee emp = s.findEmployeeById(em, 100L);
		System.out.println("Employee: " + emp.toString());
	}

}
