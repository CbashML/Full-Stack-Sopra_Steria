package com.example.mod2lab2.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.mod2lab2.model.Student;
import com.example.mod2lab2.repository.StudentsRepository;

@Component
public class StudentValidator implements Validator {

	@Autowired
	StudentsRepository repo;

	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Student user = (Student) target;
		String email = user.getEmail();
		Student userByEmail = repo.findByEmail(email);
		if (userByEmail != null) {
			errors.rejectValue("email", "email.exists", new Object[] { email }, "Email " + email + " already in use");
		}
	}

}
