package org.kamil;

import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.kamil.model.NumberBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class SpringBootValidatorMessagesApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootValidatorMessagesApplication.class, args);

		Locale.setDefault(Locale.getDefault());

		Validator validator = ctx.getBean(Validator.class);
		NumberBean number = new NumberBean(2);
		Set<ConstraintViolation<NumberBean>> errors = validator.validate(number);
		errors.forEach(err -> System.err.println(err.getMessage()));

		ctx.close();
	}

	@Bean
	public Validator validator() {
		return new LocalValidatorFactoryBean();
	}

}
