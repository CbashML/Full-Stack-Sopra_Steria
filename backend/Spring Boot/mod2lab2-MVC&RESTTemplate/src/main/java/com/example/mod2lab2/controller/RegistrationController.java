package com.example.mod2lab2.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.mod2lab2.component.StudentValidator;
import com.example.mod2lab2.model.Student;
import com.example.mod2lab2.service.RESTConsumerService;

@Controller
public class RegistrationController {

	@Autowired
	private StudentValidator validator;
	
	@Autowired
	private RESTConsumerService restConsumerService;
	
	@GetMapping("/registration")
	public String registrationForm(Model model) {
		model.addAttribute("student", new Student());
		return "registration";
	}
	
	
//	@PostMapping("/registration")
//    public String handleRegistration(Student student) {
//        //logger.debug("Registering Student : " + student);
//        return "redirect:/login";
//    }
	
	@PostMapping("/registration")
	public ModelAndView handleRegistration(@Valid Student student, BindingResult result) {
		//logger.debug("Registering Student:" + student);
		
		ModelAndView mav = new ModelAndView();
		
		validator.validate(student, result);
		if (result.hasErrors()) {
			mav.addObject("student", student);
			mav.setViewName("registration");
		} 
		else 
		{
			
			if (restConsumerService.create(student) != null) 
			{
				mav.addObject("student", student);
				mav.setViewName("registrationsucces");
			} else {

				mav.addObject("student", student);
				mav.setViewName("registration");
			}
		}
		return mav;
	}
	
}
