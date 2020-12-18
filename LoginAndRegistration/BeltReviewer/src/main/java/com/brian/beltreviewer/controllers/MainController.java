package com.brian.beltreviewer.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.brian.beltreviewer.models.Event;
import com.brian.beltreviewer.models.Message;
import com.brian.beltreviewer.models.User;
import com.brian.beltreviewer.services.EventService;
import com.brian.beltreviewer.services.MessageService;
import com.brian.beltreviewer.services.UserService;
import com.brian.beltreviewer.validators.UserValidator;

@Controller
public class MainController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private MessageService messageService;
	
	@GetMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "index.jsp";
	}
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			userService.registerUser(user);
			session.setAttribute("loggedUser", user.getId());
			return "redirect:/events";
		}
	}
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes redir, HttpSession session) {
		if(userService.authenticateUser(email, password)) {
			User user = userService.findByEmail(email);
			session.setAttribute("loggedUser", user.getId());
			return "redirect:/events";
		} else {
			redir.addFlashAttribute("error", "Invalid username or password");
			return "redirect:/";
		}
	}
	@GetMapping("/events")
	public String events(@ModelAttribute("event") Event event, Model model, HttpSession session) {
		if(session.getAttribute("loggedUser") == null) {
			return "redirect:/";
		}
		User activeUser = userService.findById((Long) session.getAttribute("loggedUser"));
		model.addAttribute("user", activeUser);
		model.addAttribute("localEvents", eventService.findByState(activeUser.getState()));
		model.addAttribute("nonlocalEvents", eventService.findByStateNot(activeUser.getState()));
		
		return "events.jsp";
	}
	@PostMapping("/events")
	public String newEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "events.jsp";
		} else {
			event.setHost(userService.findById((Long) session.getAttribute("loggedUser")));
			eventService.save(event);
			return "redirect:/events/";
		}
	}
	@GetMapping("/events/{id}")
	public String showEvent(@ModelAttribute("message") Message message, Model model, @PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("loggedUser") == null) {
			return "redirect:/";
		}
		System.out.println(eventService.findById(id).getParticipants().contains(userService.findById((Long) session.getAttribute("loggedUser"))));
		model.addAttribute("event", eventService.findById(id));
		
		return "eventInfo.jsp";
	}
	@PostMapping("/events/{id}")
	public String newMessage(@ModelAttribute("message") Message message, HttpSession session, @PathVariable("id") Long eventId) {
		message.setId(null);
		message.setEvent(eventService.findById(eventId));
		message.setPoster(userService.findById((Long) session.getAttribute("loggedUser")));
		messageService.save(message);
		
		return "redirect:/events/" + eventId;
	}
	@GetMapping("/events/{id}/edit")
	public String eventEdit(@ModelAttribute("event") Event event, @PathVariable("id") Long eventId, Model model, HttpSession session) {
		Event thisEvent = eventService.findById(eventId);
		if((Long) session.getAttribute("loggedUser") != thisEvent.getHost().getId()) {
			return "redirect:/events/" + eventId;
		}
		model.addAttribute("event", eventService.findById(eventId));
		
		return "editEvent.jsp";
	}
	@PutMapping("/events/{id}/edit")
	public String editEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, @PathVariable("id") Long id, HttpSession session) {
		if(result.hasErrors()) {
			return "editEvent.jsp";
		} else {
			event.setHost(userService.findById((Long) session.getAttribute("loggedUser")));
			eventService.save(event);
			return "redirect:/events/" + id;
		}
	}
	@GetMapping("/events/{id}/join")
	public String joinEvent(@PathVariable("id") Long id, HttpSession session) {
		userService.joinEvent(eventService.findById(id), userService.findById((Long) session.getAttribute("loggedUser")));
		return "redirect:/events/";
	}
	@GetMapping("/events/{id}/unjoin")
	public String unjoinEvent(@PathVariable("id") Long id, HttpSession session) {
		userService.unjoinEvent(eventService.findById(id), userService.findById((Long) session.getAttribute("loggedUser")));
		return "redirect:/events";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("loggedUser", null);
		return "redirect:/";
	}
}
