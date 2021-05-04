package org.kamil.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.kamil.constraint.group.Draft;
import org.kamil.constraint.group.Full;
import org.kamil.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

	private Validator validator;

	@Autowired
	public ProjectService(Validator valiator) {
		this.validator = valiator;
	}

	public boolean validateDraft(Project project) {
		Set<ConstraintViolation<Project>> errors = validator.validate(project, Draft.class);
		errors.forEach(err -> System.err.println(err.getPropertyPath() + " " + err.getMessage()));
		return errors.isEmpty() ? true : false;
	}

	public boolean validateFull(Project project) {
		Set<ConstraintViolation<Project>> errors = validator.validate(project, Full.class);
		errors.forEach(err -> System.err.println(err.getPropertyPath() + " " + err.getMessage()));
		return errors.isEmpty() ? true : false;
	}
}
