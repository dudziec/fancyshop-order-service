package de.saxsys.fancyshop.client;

import lombok.Getter;

@Getter
public enum Data {
	Customer("http://localhost:9999/fancycustomerserver/random", Customer.class),
	Item("http://localhost:8888/fancyitemserver/random", Item.class);
	
	
	private Class c;
	private String path;
	
	Data(String path,  Class c) {
		this.c = c;
		this.path = path;
	}
}
