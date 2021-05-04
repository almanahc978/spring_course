package org.kamil;

import org.kamil.dao.ClientDao;
import org.kamil.dao.OrderDao;
import org.kamil.dao.ProductDao;
import org.kamil.model.Client;
import org.kamil.model.Order;
import org.kamil.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringJpaBoot2MtmApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaBoot2MtmApplication.class, args);


	    Client client = new Client("Jan", "Kowalski", "Krakowskie przedmieście 23, Warszawa");
	    Order order = new Order("z dostawą do domu");
	    Product product1 = new Product("Telewizor LG 42'", 4800.0, "dolby surround");
	    Product product2 = new Product("Telefon Apple iPhone SE", 2200.0, "pokrowiec gratis");
	    order.getProducts().add(product1);
	    order.getProducts().add(product2);
        client.addOrder(order);

	    ClientDao clientDao = ctx.getBean(ClientDao.class);
	    clientDao.save(client);

		Client getClient = clientDao.get(client.getId());
		System.out.println("\n" + getClient);
		
		//clientDao.remove(client);
		clientDao.removeAllOrders(client);

		ctx.close();
	}

}
