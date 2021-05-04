package org.kamil;

import org.kamil.model.Book;
import org.kamil.service.BookRepository;
import org.kamil.service.GenericRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringAopApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringAopApplication.class);

		GenericRepository<String, Book> repo = ctx.getBean(BookRepository.class);

		repo.add(new Book("42424242", "Pierwsza", "Pierwszy autor"));
		repo.add(new Book("9797242324214", "Druga", "Drugi autor"));
		repo.add(new Book("2134743521221", "Trzecia", "Trzeci autor"));

		Book book = repo.get("2134743521221");
		System.out.println(book);
		
		repo.add(null);

		ctx.close();
	}

}
