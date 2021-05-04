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

import org.kamil.common.Lang;
import org.kamil.validator.BadWordValidator;

@Documented
@Constraint(validatedBy = {BadWordValidator.class})
@Retention(RUNTIME)
@Target({ FIELD, METHOD, PARAMETER, CONSTRUCTOR, ANNOTATION_TYPE })
public @interface NotBadWord {

	String message() default "You cannot use bad words in your message!";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	Lang[] lang() default Lang.PL;
}
