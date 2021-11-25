package za.co.business.controllers;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class HomeController {
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Value("${project.version}")
	private String projectVersion;
	
	@Value("${project.name}")
	private String projectName;

	@GetMapping("business-dashboard") //business-dashboard
	public String displayHome1(Model model) {
		return "redirect:/business-dashboard/home";
	}
	
	@GetMapping("/home")
	public String displayHome2(Model model) {
		return "redirect:/business-dashboard/home";
	}
	
	@GetMapping
	public String displayHome(Model model) {
		return "redirect:/business-dashboard/home";
	}

	@GetMapping("/business-dashboard/home")
	public String displayHomePage(Model model) {	
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String simpleDate = simpleDateFormat.format(new Date());
		model.addAttribute("simpleDate", simpleDate);
		model.addAttribute("timestamp", Instant.now());
		
		model.addAttribute("projectVersion", projectVersion);
		model.addAttribute("projectName", projectName);

		return "main/home";
	}
	


}
