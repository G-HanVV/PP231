package web.controller;

import web.config.WebConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.hiber.model.Car;
import web.hiber.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	{

	}

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		System.out.println("123456");
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);

		return "index";
	}

}