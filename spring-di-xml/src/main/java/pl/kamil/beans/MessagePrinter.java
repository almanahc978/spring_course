package pl.kamil.beans;

public class MessagePrinter {

	private MessageProducer message;

	public MessageProducer getMessage() {
		return message;
	}

	public void setMessage(MessageProducer message) {
		this.message = message;
	}

	public MessagePrinter() {

	}

	public MessagePrinter(MessageProducer messageProducer) {
		super();
		this.message = messageProducer;
	}

	public void print() {
		System.out.println(message.getMessage());
	}

}
