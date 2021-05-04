package pl.kamil.beans;

/*import javax.inject.Inject;
*/
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

	@Autowired /* wstrzykiwanie przez kontruktor */
	public MessagePrinter(@Qualifier("fileMessageProducer") MessageProducer messageProducer) {
		super();
		this.producer = messageProducer;
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

	@Autowired(required = false) /* dekorator jest opcjonalny(requirde = false) */
	public void setDecorator(@Qualifier("lowerClassMessageDecorator") MessageDecorator decorator) {
		this.decorator = decorator;
	}

	public void print() {
		String message = producer.getMessage();
		message = decorator != null ? decorator.decorate(message) : message;
		System.out.println(message);
	}

}
