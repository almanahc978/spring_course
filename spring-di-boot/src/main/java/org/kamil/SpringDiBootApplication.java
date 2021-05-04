package org.kamil;

import java.util.List;

import org.kamil.beans.NameRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication /*rownowaznik tego co na dole*/
/*
 * @Configuration
 * 
 * @EnableAutoConfiguration
 * 
 * @ComponentScan
 */
public class SpringDiBootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringDiBootApplication.class, args);

        NameRepository namesRepo = ctx.getBean(NameRepository.class);
        List<String> allNames = namesRepo.getAll();
        allNames.forEach(System.out::println);

        ctx.close();
	}

}
