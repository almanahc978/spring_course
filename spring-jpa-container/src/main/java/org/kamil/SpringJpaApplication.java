package org.kamil;

import org.kamil.dao.BookDao;
import org.kamil.dao.BookDaoImpl;
import org.kamil.model.Book;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringJpaApplication {

	public static void main(String[] args) throws InterruptedException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJpaApplication.class);
		BookDao bookDao = ctx.getBean(BookDao.class);
		
		//save
		
		Book book = new Book("1234567890468", "Spring is so cool", "Spring");
		bookDao.save(book);
		
		//read
		
		Book bookGet = bookDao.get(1L);
		System.out.println(bookGet);
		
		Thread.sleep(5000);
		
		ctx.close();
	}
}
