package com.capitanperegrina.geniusrating.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GNPublicController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GNPublicController.class);

	@GetMapping("/main.do")
	public String main(final Model model) {
		LOGGER.debug("Mostrando mensaje");
		return "main";
	}
}
