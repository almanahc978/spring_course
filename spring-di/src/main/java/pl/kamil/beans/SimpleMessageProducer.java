package pl.kamil.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
/*
 * @Primary jeżeli wstzrykiwane zależnosci są niejednoznaczne(np. dwie klasy
 * implemetują te same interfejsy)
 */
@Qualifier("simpleMessageProducer")
public class SimpleMessageProducer implements MessageProducer {

	@Override
	public String getMessage() {
		return "Example message " + System.currentTimeMillis();
	}
}
