package de.saxsys.fancyshop.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {

	@GetMapping(value="/index")
	public String index()
	{
		return "index";
	}
	
}
