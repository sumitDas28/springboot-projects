package com.sumit.learnjava.restapi.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
}
