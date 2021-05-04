package org.kamil.beans;



import org.kamil.beans.Message.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

	/* @Autowired wstrzykiwanie do pola, nie zalecane */
	/* @Inject pojdejsciee używając adnotacji z JavyEE */
	private MessageProducer producer;

	public MessagePrinter() {

	}

	@Autowired
	public MessagePrinter(@Message(type = MessageType.FILE) MessageProducer producer) {
		this.producer = producer;
	}

	public MessageProducer getMessage() {
		return producer;
	}

	/* @Autowired - wstrzykiwanie przez setter */
	public void setMessage(MessageProducer message) {
		this.producer = message;
	}

	public void print() {
		System.out.println(producer.getMessage());
	}

}
