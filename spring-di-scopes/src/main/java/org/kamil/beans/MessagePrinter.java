package org.kamil.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MessagePrinter {

	private MessageProducer producer;
	
	public MessageProducer getProducer() {
		return producer;
	}

	@Autowired
	public void setProducer(MessageProducer producer) {
		this.producer = producer;
	}

	public void printMessage() {
		System.out.println(producer.getNumber());
	}
}
