package pl.kamil.app;

/*import org.springframework.context.annotation.Bean;*/
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.kamil.beans.MessagePrinter;
/*import pl.kamil.beans.MessageProducer;
import pl.kamil.beans.SimpleMessageProducer;*/

/*  @Configuration jest jedną z podstawowych adnotacji wykorzystywanych w Springu,
 *  podczas skanowania klas Spring tworzy odpowiednie obiekty,
 *  które w klasach tak opatrzonych są zdefiniowane. Adnotacja @Bean na poziomie metody sprawia,
 *  że jej wynik, czyli obiekt typu MessagePrinter staje się ziarnem zarządzanym przez kontener Springa.
*/
@Configuration
@ComponentScan(basePackageClasses = MessagePrinter.class)
public class ApplicationConfig {

	/*
	 * @Bean(name = "myMessagePrinter") public MessagePrinter getPrinter() {
	 * MessageProducer producer = new SimpleMessageProducer();
	 * 
	 * return new MessagePrinter(producer);
	 * 
	 * }
	 */

}
