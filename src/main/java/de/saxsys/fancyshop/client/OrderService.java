package de.saxsys.fancyshop.client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.Getter;

@Component
@Getter
public class OrderService  {
	private List<Order> shoppingCart = new ArrayList<>();
	
	public Order createOrder()
	{
		Order order = new Order();
		try {
			
			CompletableFuture.supplyAsync(() -> (Customer)getData(Data.Customer))				
			.thenAccept(c -> order.setCustomer(c)).get();
			
			for(int i=0; i<5; i++) {
				CompletableFuture.supplyAsync(() -> (Item)getData(Data.Item))
				.thenAccept(it -> order.getItems().add(it)).get();
			}
			
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		return order;
	}
	
	public Object getData(Data data)
	{
		RestTemplate restTemplate = new RestTemplate();
		
		@SuppressWarnings("unchecked")
		Object object = restTemplate.getForObject(data.getPath(), data.getC());
		return object;
	}
}
