package org.kamil;

import java.util.ArrayList;
import java.util.List;

import org.kamil.model.Car;
import org.kamil.repository.CarRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringDataApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringDataApplication.class);
        CarRepository carRepo = ctx.getBean(CarRepository.class);

		
		List<Car> cars = new ArrayList<>();
		
        cars.add(new Car("A4", "Audi", 49000.0));
        cars.add(new Car("Auris", "Toyota", 35000.0));
        cars.add(new Car("Insignia", "Opel", 29500.0));
        
        cars.forEach(carRepo::save);
        
        Car first = carRepo.findById(1L).get();
        carRepo.delete(first);
        
        carRepo.findAll().forEach(System.out::println);
        
	}
}
