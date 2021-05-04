package org.kamil;


import org.kamil.model.Person;
import org.kamil.service.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@ComponentScan
public class SpringValidationApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringValidationApp.class);
		
		PersonService personService = ctx.getBean(PersonService.class);
		
		Person person1 = new Person("Jan", "Kowalski", "jan@kowalski.org", 35);
		System.out.println("Adding " + person1);
		personService.addPerson(person1);
		
		Person person2 = new Person("Ania", null, "zlyEmail", 0);
		System.out.println("Adding " + person2);
		personService.addPerson(person2);
		
		System.out.println("People size " + personService.getPeople().size());
		for(Person p : personService.getPeople()) {
			System.out.println(p);
		}
		
		ctx.close();
	}
	
}
