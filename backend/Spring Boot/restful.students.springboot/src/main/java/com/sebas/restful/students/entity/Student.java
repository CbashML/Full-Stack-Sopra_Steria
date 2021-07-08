package com.sebas.restful.students.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "STUDENT")
public class Student {

	@Id
	@Column(name = "student_id")
	@SequenceGenerator(name="gen_student_seq" , sequenceName = "Students_sequence", allocationSize = 1)
	@GeneratedValue(generator = "gen_student_seq")
    private long id;

    @NotNull
    @Size(min=2, max=32)
    @Column(name = "student_name")
    private String name;
    
    @NotNull
    @Size(min=2, max=32)
    @Email(message="{invalid.email}")
    private String email;
    
    @NotNull
    @Size(min=6, max=64)
    @Column(name = "student_password")
    private String password;

    public Student() {}
    
	public Student(@NotNull @Size(min = 2, max = 32) String name,
			@NotNull @Size(min = 2, max = 32) @Email(message = "{invalid.email}") String email,
			@NotNull @Size(min = 6, max = 64) String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Student(long id, @NotNull @Size(min = 2, max = 32) String name,
			@NotNull @Size(min = 2, max = 32) @Email(message = "{invalid.email}") String email,
			@NotNull @Size(min = 6, max = 64) String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}



	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}

}