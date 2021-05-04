package org.kamil.controller;

import org.kamil.component.EventHolder;
import org.kamil.model.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EventController {

	public EventHolder eventHolder;

	@Autowired
	public EventController(EventHolder eventHolder) {
		this.eventHolder = eventHolder;
	}

	@PostMapping("/register")
	public String register(@RequestParam String firstName, @RequestParam String lastName) {
		Participant particpant = new Participant(firstName, lastName);
		if (eventHolder.checkRegistartion(particpant)) {
			return "redirect:error";
		} else {
			eventHolder.addPatricipant(particpant);
			return "redirect:success";
		}
	}
	
	@GetMapping("/success")
	public String success() {
		return "success";
	}
	
	@GetMapping("/error")
	public String error() {
		return "error";
	}
	
	@GetMapping("/show")
	public String show() {
		for(Participant p : eventHolder.getParticipants()) {
			System.out.println(p);
		}
		
		return "redirect:/";
	}

}
