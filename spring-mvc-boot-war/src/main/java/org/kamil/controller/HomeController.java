package org.kamil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(@RequestParam(name = "username", defaultValue = "stranger", required = true) String username,
			@RequestHeader("user-agent") String userAgent, @RequestParam(name = "age", defaultValue = "20") int age) {
		System.out.println("Hello " + username);
		System.out.println("Age " + age);
		System.out.println("Web browser " + userAgent);
		return "home";
	}
	
	@PostMapping("/")
	public String calculate(@RequestParam(defaultValue = "0") int valueA, @RequestParam(defaultValue = "0") int valueB) {
		int sum = valueA + valueB;
		System.out.printf("%d + %d = %d", valueA, valueB, sum);
		return "home";
	}
}
