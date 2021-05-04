package pl.kamil.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.kamil.beans.MessagePrinter;

public class SpringDiApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans-config.xml");
		MessagePrinter printer = classPathXmlApplicationContext.getBean(MessagePrinter.class);
		/*
		 * 
		 * MessagePrinter printer = classPathXmlApplicationContext.getBean("messagePrinter");
		 * 
		 * 
		 * */
		printer.print();
		classPathXmlApplicationContext.close();
	}
}
