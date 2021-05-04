package org.kamil;

import java.util.List;

import org.kamil.beans.NameRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringDiApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringDiApplication.class);

		NameRepository namesRepo = ctx.getBean(NameRepository.class);
		List<String> allNames = namesRepo.getAll();
		allNames.forEach(System.out::println);

		ctx.close();
	}
}
