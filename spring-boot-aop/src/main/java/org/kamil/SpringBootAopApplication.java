package org.kamil;

import org.kamil.model.Book;
import org.kamil.service.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringBootAopApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootAopApplication.class, args);
		
		BookRepository repo = ctx.getBean(BookRepository.class);
		
		repo.add(new Book("1234567890123", "Pierwsza", "Pierwszy autor"));
        repo.add(new Book("2345678901234", "Druga", "Drugi autor"));
        repo.add(new Book("3456789012345", "Trzecia", "Trzeci autor"));
	
        Book book = repo.get("1234567890123");
        System.out.println(book);
        
        ctx.close();
	}

}
