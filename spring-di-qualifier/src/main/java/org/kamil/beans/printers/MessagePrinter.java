package org.kamil.beans.printers;

import org.kamil.beans.decorators.MessageDecorator;
import org.kamil.beans.producers.FileMessage;
import org.kamil.beans.producers.MessageProducer;
import org.kamil.beans.producers.Producer;
import org.kamil.beans.producers.Producer.ProducerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

	/* @Autowired wstrzykiwanie do pola, nie zalecane */
	/* @Inject pojdejsciee używając adnotacji z JavyEE */
	private MessageProducer producer;
	private MessageDecorator decorator;

	public MessagePrinter() {

	}

	@Autowired
	public MessagePrinter(@Producer(type = ProducerType.SIMPLE) MessageProducer producer) {
		this.producer = producer;
	}

	public MessageProducer getMessage() {
		return producer;
	}

	/* @Autowired - wstrzykiwanie przez setter */
	public void setMessage(MessageProducer message) {
		this.producer = message;
	}

	public MessageDecorator getDecorator() {
		return decorator;
	}

	@Autowired(required = false) /* dekorator jest opcjonalny(required = false) */
	public void setDecorator(@Qualifier("lowerClassMessageDecorator") MessageDecorator decorator) {
		this.decorator = decorator;
	}

	public void print() {
		String message = producer.getMessage();
		message = decorator != null ? decorator.decorate(message) : message;
		System.out.println(message);
	}

}
