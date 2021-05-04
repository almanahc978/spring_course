package org.kamil;

import org.kamil.model.Person;
import org.kamil.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class SpringBootValidatorApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootValidatorApplication.class, args);
		PersonService personService = ctx.getBean(PersonService.class);

		Person person1 = new Person("Jan", "Kowalski", "jan@kowalski.org", 35);
		personService.addPerson(person1);

		Person person2 = new Person("Anna", null, "zlyEmail", 0);
		personService.addPerson(person2);

		System.out.println("People " + personService.getPeople().size());
		for (Person p : personService.getPeople()) {
			System.out.println(p);
		}

		ctx.close();
	}

	@Bean
	public Validator validator() {
		return new LocalValidatorFactoryBean();
	}

}
