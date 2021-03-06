package org.kamil.controller;

import org.kamil.component.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrintCartController {

	private ShoppingCart cart;

	@Autowired
	public PrintCartController(ShoppingCart cart) {
		this.cart = cart;
	}

	@GetMapping("/print")
	public String printProducts() {
		for (String product : cart.getProducts()) {
			System.out.println(product);
		}

		return "index.jsp";
	}
}
