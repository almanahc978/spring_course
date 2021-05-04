package org.kamil;

import org.kamil.dao.ClientDao;
import org.kamil.dao.OrderDao;
import org.kamil.model.Client;
import org.kamil.model.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringJpaBoot2OtmApplication {

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaBoot2OtmApplication.class, args);
		ClientDao clientDao = ctx.getBean(ClientDao.class);
		OrderDao orderDao = ctx.getBean(OrderDao.class);

		Client client = new Client("Jan", "Kowalski", "Wylotna, Białystok");

		clientDao.save(client);
		System.out.println(client);

		Order order = new Order("Telewizor LG", "42', dostawa do domu");
		order.setClient(client);

		orderDao.save(order);

		Order getOrder = orderDao.get(1L);
		System.out.println(getOrder);

		Client getClient = clientDao.get(1L);
		System.out.println(getClient);

		ctx.close();
	}

}
