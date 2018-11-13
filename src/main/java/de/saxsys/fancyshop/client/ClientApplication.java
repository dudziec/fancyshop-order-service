package de.saxsys.fancyshop.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
		
		OrderService service = new OrderService();
		
		for(int i=0; i<5; i++) 
		{
			Order order = service.createOrder();
			service.getShoppingCart().add(order);
			
			System.out.println(order.getCustomer().toString());
			System.out.println(order.getItems().toString());
			
			System.out.println("Price " + order.summarizeOrder());
		}
	}

	
}
