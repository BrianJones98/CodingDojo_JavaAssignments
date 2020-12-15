package com.brian.controllerviews.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.brian.controllerviews.models.User;
import com.brian.controllerviews.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/registration";
	}
	@GetMapping("/registration")
	public String register(@ModelAttribute("user") User user) {
		return "registration.jsp";
	}
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "registration.jsp";
		} else {
			userService.registerUser(user);
			session.setAttribute("loggedUser", user.getId());
			return "redirect:/home";
		}
	}
	@GetMapping("/login")
	public String login() {
		return "login.jsp";
	}
	@PostMapping("/login")
	public String checkLogin(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
		if(userService.authenticateUser(email, password)) {
			User user = userService.findByEmail(email);
			session.setAttribute("loggedUser", user.getId());
			return "redirect:/home";
		} else {
			model.addAttribute("error", "Invalid username or password");
			return "login.jsp";
		}
	}
	@GetMapping("/home")
	public String home(HttpSession session, Model model) {
		if(session.getAttribute("loggedUser") == null) {
			return "redirect:/registration";
		} else {
			model.addAttribute("user", userService.findUserById((Long) session.getAttribute("loggedUser")));
			return "home.jsp";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("loggedUser", null);
		return "redirect:/login";
	}
}
