package com.brian.thecode;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		session.setAttribute("hasAccess", false);
		
		return "index.jsp";
	}
	@RequestMapping(value="/tryCode", method=RequestMethod.POST)
	public String tryCode(@RequestParam(value="code") String code, RedirectAttributes redirectAttributes, HttpSession session) {
		if(code.equals("bushido")) {
			session.setAttribute("hasAccess", true);
			return "redirect:/code";
		}
		else {
			redirectAttributes.addFlashAttribute("error", "You must train harder!");
			return "redirect:/";
		}
	}
	@RequestMapping("/code")
	public String code(HttpSession session, RedirectAttributes redirectAttributes) {
		if((Boolean) session.getAttribute("hasAccess")) {
			return "code.jsp";
		}
		else {
			redirectAttributes.addFlashAttribute("error", "You must train harder!");
			return "redirect:/";
		}
	}
}
