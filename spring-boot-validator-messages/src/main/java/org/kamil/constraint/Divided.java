package org.kamil.constraint;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.kamil.validator.NumberDivideValidator;

@Documented
@Constraint(validatedBy = NumberDivideValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD, PARAMETER, CONSTRUCTOR, ANNOTATION_TYPE })
public @interface Divided {

	String message() default "{org.kamil.constraint.Divided.message}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	int by() default 1;
}
