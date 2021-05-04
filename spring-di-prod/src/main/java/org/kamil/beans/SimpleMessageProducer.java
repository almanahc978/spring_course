package org.kamil.beans;

import org.kamil.beans.Message.MessageType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
 * @Primary jeÅ¼eli wstzrykiwane zaleÅ¼nosci sÄ… niejednoznaczne(np. dwie klasy
 * implemetujÄ… te same interfejsy)
 */

/*
 * @Qualifier("simpleMessageProducer") - moozna sie pomylić w stringu
 */
@Component
@Message(type = MessageType.SIMPLE)
public class SimpleMessageProducer implements MessageProducer {

	private int random;

	public int getRandom() {
		return random;
	}

	@Autowired
	public void setRandom(@Qualifier("randomNumber") int random) {
		this.random = random;
	}

	@Override
	public String getMessage() {
		return "Simple message " + this + " : " + random;
	}
}
