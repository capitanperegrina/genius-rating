package com.capitanperegrina.geniusrating.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.capitanperegrina.geniusrating.core.service.boat.BoatService;
import com.capitanperegrina.geniusrating.core.view.boatListView.BoatListView;
import com.capitanperegrina.simpleuser.web.naming.SimpleUserWebNaming;
import com.capitanperegrina.simpleuser.web.ui.UserUI;

@Controller
public class GNPublicController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GNPublicController.class);
    
    @Autowired(required = true)
    private BoatService boatService;

	@GetMapping("/main.do")
	public String main(final Model model) {
		return "main";
	}
	
	@GetMapping("/boatList.do")
	public String boatList(final Model model, HttpServletRequest request) {
		List<BoatListView> boats = this.boatService.findAll(2020);
		request.setAttribute("boats", boats);
		// TODO - Why this shit is not set in the filter?
		request.setAttribute(SimpleUserWebNaming.REQUEST_LANG, LocaleContextHolder.getLocale().getLanguage());
		return "boatList";
	}
	
	@GetMapping("/myBoats.do")
	public String myBoats(final Model model, HttpServletRequest request) {
		List<BoatListView> myBoats = this.boatService.findByUserId(2020, ((UserUI) request.getSession().getAttribute(SimpleUserWebNaming.SESSION_LOGGED_USER)).getUserId());
		request.setAttribute("boats", myBoats);
		// TODO - Why this shit is not set in the filter?		
		request.setAttribute(SimpleUserWebNaming.REQUEST_LANG, LocaleContextHolder.getLocale().getLanguage());
		return "boatList";
	}
}
