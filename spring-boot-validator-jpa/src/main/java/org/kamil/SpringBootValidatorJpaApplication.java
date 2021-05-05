package org.kamil;

import org.kamil.model.Person;
import org.kamil.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootValidatorJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootValidatorJpaApplication.class, args);
		PersonService personService = ctx.getBean(PersonService.class);
		
		Person person = new Person("Jan", null, "zlyEmail", 0);
		
		personService.add(person);
		
		/*
		 * mimo iz w pliku application.properties jest ustawione spring.jpa.show-sql-true to nic sie nie pokazuje bo
		 * gdy jest zlamane jakiekolwiek ograniczenie Hibernate nie probuje zapisac obiektu do bazy danych
		 * 
		 * */
		
		ctx.close();
	}

}
