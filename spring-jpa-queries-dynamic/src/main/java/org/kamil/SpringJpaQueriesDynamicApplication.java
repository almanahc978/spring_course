package org.kamil;

import java.util.ArrayList;
import java.util.List;

import org.kamil.dao.ProductDao;
import org.kamil.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringJpaQueriesDynamicApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =  SpringApplication.run(SpringJpaQueriesDynamicApplication.class, args);
        ProductDao productDao = ctx.getBean(ProductDao.class);
		
        List<Product> products = new ArrayList<>();
        products.add(new Product("Telewizor", "Samsung", 4500.0));
        products.add(new Product("Opiekacz", "Opiex", 120.0));
        products.add(new Product("Laptop", "Samsung", 3599.0));
        products.add(new Product("Kino domowe", "Yamaha", 2600.0));
        products.add(new Product("Smartfon", "Sony", 2100.0));
        
        products.forEach(productDao::save);
        
        productDao.removeByProducer("Samsung");
        System.out.println("Products without Samsung:");
        productDao.getAll().forEach(System.out::println);

        System.out.println("Opiekacze:");
        List<Product> productByName = productDao.getByName("Opiekacz");
        System.out.println(productByName);
        
        ctx.close();
	}

}
