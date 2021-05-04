package org.kamil;

import org.kamil.dao.BookDao;
import org.kamil.model.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class SpringJpaBootApplication {

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaBootApplication.class, args);
		BookDao bookDao = ctx.getBean(BookDao.class);

		//CREATE
		Book book = new Book("1234567890468", "Spring is so cool", "Spring");
		bookDao.save(book);

		// UPDATE
		
		Book book2 = new Book("987654321", "Spring is NOT so cool", "Javastart");
		book2.setId(1L);
		bookDao.update(book2);
		
		//READ
		
		Book findBook = bookDao.get(1L);
		System.out.println(findBook);
		
		//DELETE
		
		bookDao.remove(1L);

		Book book3 = bookDao.get(1L);
		System.out.println(book3);

		Thread.sleep(5000);
	}
}
