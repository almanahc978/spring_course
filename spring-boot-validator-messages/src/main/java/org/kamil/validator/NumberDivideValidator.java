package org.kamil.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kamil.constraint.Divided;

public class NumberDivideValidator implements ConstraintValidator<Divided, Integer> {

	int divider;

	@Override
	public void initialize(Divided annotation) {
		divider = annotation.by();
	}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		return value % divider == 0;
	}

}
