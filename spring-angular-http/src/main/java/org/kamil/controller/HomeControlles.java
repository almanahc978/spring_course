package org.kamil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeControlles {

	@RequestMapping("/")
	public String home() {
		return "index.html";
	}
}
