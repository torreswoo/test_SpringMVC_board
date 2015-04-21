package com.skplanet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {

	@RequestMapping		// /
	public String printRoot(ModelMap model) {
		model.addAttribute("message", "root!");
		return "test/hello";
	}

	@RequestMapping(value="/test/hello", method = RequestMethod.GET) // /test/hello
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "test/hello";
	}

	@RequestMapping(value="/test/test1", method = RequestMethod.GET)
	public String printTest(ModelMap model) {
		model.addAttribute("message", "test");
		return "test/hello";
	}

}