package org.kamil;

import javax.validation.Validator;

import org.kamil.model.Message;
import org.kamil.service.MessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class SpringBootCustomConstrainsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootCustomConstrainsApplication.class, args);
		MessageService messageService = ctx.getBean(MessageService.class, args);

		Message msg = new Message("Hello message", "Fak to brzydkie słowo");
		boolean verifyMessage = messageService.verifyMessage(msg);
		System.out.println("Wiadomość poprawma? " + verifyMessage);
		ctx.close();
	}

	@Bean
	public Validator validator() {
		return new LocalValidatorFactoryBean();
	}

}
