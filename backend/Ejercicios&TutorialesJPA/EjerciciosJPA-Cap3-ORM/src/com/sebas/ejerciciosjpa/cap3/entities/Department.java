package com.sebas.ejerciciosjpa.cap3.entities;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sebas.ejerciciosjpa.cap3.embeddable.Manager;

@Entity
@Table(name = "DEPARTMENTS")
@Access(AccessType.FIELD)
public class Department {

	@Id
	@SequenceGenerator(name = "GEN_DEPARTMENTS_SEQ", sequenceName = "DEPARTMENTS_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "GEN_DEPARTMENTS_SEQ")
	private long department_id;

	@Transient
	private String department_name;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "MANAGER_ID")) })
	private Manager manager;

	@OneToMany(mappedBy = "department")
	List<Employee> employees;

	public Department() {

	}
	
	public Department(String department_name, Manager manager) {
		this.department_name = department_name;
		this.manager = manager;
	}



	public long getDepartment_id() {
		return department_id;
	}

	public long setDepartment_id(long id) {
		return department_id;
	}

	@Access(AccessType.PROPERTY)
	@Column(name = "DEPARTMENT_NAME")
	public String getDepartment_name() {
		if (department_name.length() < 10) {
			department_name = "dep. " + department_name;
		}
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department_name == null) ? 0 : department_name.hashCode());
		result = prime * result + (int) (department_id ^ (department_id >>> 32));
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Department)) {
			return false;
		}
		Department other = (Department) obj;
		if (department_name == null) {
			if (other.department_name != null) {
				return false;
			}
		} else if (!department_name.equals(other.department_name)) {
			return false;
		}
		if (department_id != other.department_id) {
			return false;
		}
		if (employees == null) {
			if (other.employees != null) {
				return false;
			}
		} else if (!employees.equals(other.employees)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Department [department_id=" + department_id + ", department_name=" + department_name + ", managerId="
				+ manager.getId() + ", employees=" + (employees != null ? employees.size() : "0") + "]";
	}

}
