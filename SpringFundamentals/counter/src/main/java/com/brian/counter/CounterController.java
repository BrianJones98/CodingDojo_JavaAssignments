package com.brian.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		
		if(count == null) {
			count = 0;
		}
		
		count++;
		session.setAttribute("count", count);
		
		return "index.jsp";
	}
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		Integer count = (Integer) session.getAttribute("count");
		
		if(count == null) {
			session.setAttribute("count", 0);
		}
		
		model.addAttribute("count", session.getAttribute("count"));
		
		return "counter.jsp";
	}
	@RequestMapping("/plusTwo")
	public String plusTwo(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		
		if(count == null) {
			count = 0;
		}
		
		count += 2;
		session.setAttribute("count", count);
		
		return "plusTwo.jsp";
	}
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("count", (Integer) 0);
		
		return "redirect:/counter";
	}
}
