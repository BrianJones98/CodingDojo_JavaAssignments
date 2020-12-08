package com.brian.displaydate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEE', the' d 'of' MMMMM',' yyyy");
		Date now = new Date();
		model.addAttribute("date", dateFormat.format(now));
		return "date.jsp";
	}
	@RequestMapping("/time")
	public String time(Model model) {
		SimpleDateFormat timeFormat = new SimpleDateFormat("K:mm a");
		Date now = new Date();
		model.addAttribute("time", timeFormat.format(now));
		return "time.jsp";
	}
}
