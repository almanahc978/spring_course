package org.kamil.validator;

import org.kamil.model.Person;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

	private static final int MIN_AGE = 1;

	public boolean supports(Class<?> clazz) {
		return Person.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Person person = (Person) target;
		checkEmail(person, errors);
		checkAge(person, errors);
	}

	private void checkAge(Person person, Errors errors) {
		if (person.getAge() < PersonValidator.MIN_AGE) {
			errors.rejectValue("age", "invalid");
		}
	}

	private void checkEmail(Person person, Errors errors) {
		if (person.getEmail() == null) {
			errors.rejectValue("email", "required");
		} else if (!person.getEmail().contains("@")) {
			errors.rejectValue("email", "invalid");
		}
	}

}
