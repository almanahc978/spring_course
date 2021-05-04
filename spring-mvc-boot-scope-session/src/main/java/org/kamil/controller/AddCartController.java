package org.kamil.controller;

import org.kamil.component.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddCartController {

	private ShoppingCart cart;

	@Autowired
	public AddCartController(ShoppingCart cart) {
		this.cart = cart;
	}

	@PostMapping("/add")
	public String addProduct(@RequestParam String product) {
		cart.addProduct(product);

		return "index.jsp";
	}
}
