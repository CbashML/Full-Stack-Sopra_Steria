package com.sebas.ejerciciosjpa.cap3.services;

import javax.persistence.EntityManager;

import com.sebas.ejerciciosjpa.cap3.embeddable.Manager;
import com.sebas.ejerciciosjpa.cap3.entities.Department;


public class ServiceDepartment {

	public Department createDepartment(EntityManager em, String departmentName, long managerId) {
		Department d = new Department(departmentName, new Manager(managerId));
		try {
			em.persist(d);
		} catch (Exception e) {
			System.out.println("||Exception|| " + e.getMessage());
			return null;
		}
		return d;
	}
	
}
