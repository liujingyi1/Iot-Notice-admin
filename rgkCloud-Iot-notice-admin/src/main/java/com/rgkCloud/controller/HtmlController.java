package com.rgkCloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlController extends BaseController {
	
	@Value("${home.url}")
	private String homeUrl;
	@Value("${logout.url}")
	private String logoutUrl;

	@RequestMapping("/home")
	public String homePage(Model model) {
		model.addAttribute("homeUrl", homeUrl);
		model.addAttribute("logoutUrl", logoutUrl);
		return "home";
	}

	@GetMapping(value = "/notice.html")
	public String notice() {
		log.info("------ notice -----");
		return "notice";
	}
	@GetMapping(value = "/notice-create.html")
	public String noticeCreate() {
		log.info("------ noticeCreate -----");
		return "notice-create";
	}
	

	

	
	
	
	
	
	
	
	
	
}
