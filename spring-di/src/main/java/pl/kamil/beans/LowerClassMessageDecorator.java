package pl.kamil.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("lowerClassMessageDecorator")

public class LowerClassMessageDecorator implements MessageDecorator {

	@Override
	public String decorate(String message) {
		return message.toLowerCase();
	}
}
