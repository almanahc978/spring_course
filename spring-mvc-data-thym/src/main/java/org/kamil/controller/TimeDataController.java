package org.kamil.controller;

import java.util.List;

import org.kamil.data.TimeDataRepository;
import org.kamil.model.TimeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TimeDataController {

	private TimeDataRepository timeDataRepo;

	@Autowired
	public TimeDataController(TimeDataRepository timeDataRepo) {
		this.timeDataRepo = timeDataRepo;
	}

	@PostMapping("/save")
	public String saveTime(@ModelAttribute TimeData timeData) {
		timeDataRepo.save(timeData);

		return "redirect:/";
	}

	@GetMapping("/show")
	public String showAll(Model model) {
		List<TimeData> allTimes = timeDataRepo.findAll();
		model.addAttribute("allTimes", allTimes);

		return "showall";
	}

}
