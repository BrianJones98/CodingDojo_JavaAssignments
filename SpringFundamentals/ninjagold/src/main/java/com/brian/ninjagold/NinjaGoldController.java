package com.brian.ninjagold;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class NinjaGoldController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("gold") == null || session.getAttribute("activities") == null) {
			session.setAttribute("gold", 0);
			session.setAttribute("activities", "");
		}
		
		if((Integer) session.getAttribute("gold") < -100) {
			return "redirect:/prison";
		}
		
		return "index.jsp";
	}
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String process(HttpSession session, @RequestParam(value="action") String action) {
		int gold = (Integer) session.getAttribute("gold");
		String activities = (String) session.getAttribute("activities");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy K:mm a");
		Date now = new Date();
		
		String timeStamp = dateFormat.format(now);
		
		GoldProcessor process = new GoldProcessor();
		int amount = process.getAmount(action);
		gold += amount;
		
		if(amount > 0) {
			activities += "<p class='green'>You entered a " + action + " and earned " + amount + " gold (" + timeStamp + ")</p>\n";
		}
		else {
			activities += "<p class='red'>You entered a " + action + " and lost " + amount*-1 + " gold.. Ouch. (" + timeStamp + ")</p>\n";
		}
		
		session.setAttribute("activities", activities);
		session.setAttribute("gold", gold);
		
		return "redirect:/";
	}
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("activities", "");
		session.setAttribute("gold", 0);
		
		return "redirect:/";
	}
	@RequestMapping("/prison")
	public String prison() {
		return "prison.jsp";
	}
}
