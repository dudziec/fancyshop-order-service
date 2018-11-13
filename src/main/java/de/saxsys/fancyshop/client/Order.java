package de.saxsys.fancyshop.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Order {
	private Long id;
	private Customer customer;
	
	private List<Item> items = new ArrayList<>();
	private Date date;
	
	public Integer summarizeOrder() 
	{
		Integer sum = 0;
		for(Item item: items)
		{
			sum += item.getPrice();
		}
		return sum;
	}
}
