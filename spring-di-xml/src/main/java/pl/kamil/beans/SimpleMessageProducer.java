package pl.kamil.beans;

public class SimpleMessageProducer implements MessageProducer {

	@Override
	public String getMessage() {
		return "Example message " + System.currentTimeMillis();
	}
}
