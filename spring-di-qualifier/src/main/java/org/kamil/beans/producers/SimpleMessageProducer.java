package org.kamil.beans.producers;

import org.kamil.beans.producers.Producer.ProducerType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


/*
 * @Primary jeÅ¼eli wstzrykiwane zaleÅ¼nosci sÄ… niejednoznaczne(np. dwie klasy
 * implemetujÄ… te same interfejsy)
 */

/*
 * @Qualifier("simpleMessageProducer") - moozna sie pomylić w stringu
 */
@Component
@Producer(type = ProducerType.SIMPLE)
public class SimpleMessageProducer implements MessageProducer {

	@Override
	public String getMessage() {
		return "Example message " + System.currentTimeMillis();
	}
}
