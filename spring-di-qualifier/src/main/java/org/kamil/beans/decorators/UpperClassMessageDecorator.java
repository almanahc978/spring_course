package org.kamil.beans.decorators;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("upperClassMessageDecorator")
/*
 * @Primary
 */
public class UpperClassMessageDecorator implements MessageDecorator{

	@Override
	public String decorate(String message) {
		return message.toUpperCase();
	}
}
