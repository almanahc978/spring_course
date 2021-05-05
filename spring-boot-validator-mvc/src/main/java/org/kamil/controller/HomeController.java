package org.kamil.controller;

import java.util.List;

import javax.validation.Valid;

import org.kamil.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
		Person person = new Person();
		model.addAttribute(person);
		return "home";
	}
	
	@PostMapping("/")
	public String consumeForm(@Valid @ModelAttribute Person person, BindingResult result) {
		if(result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			errors.forEach(err->System.err.println(err.getDefaultMessage()));
		}
		
		return "home";
	}
}
