package com.brian.dojoninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.brian.dojoninjas.models.Dojo;
import com.brian.dojoninjas.models.Ninja;
import com.brian.dojoninjas.services.DojoService;
import com.brian.dojoninjas.services.NinjaService;

@Controller
public class MainController {
	
	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	
	@GetMapping("/")
	private String index() {
		return "redirect:/dojos/new";
	}
	
	@GetMapping("/dojos/new")
	private String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	@PostMapping("/dojos/new")
	private String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		} else {
			dojoService.save(dojo);
			return "redirect:/ninjas/new";
		}
	}
	@GetMapping("/ninjas/new")
	private String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoService.findAll());
		return "newNinja.jsp";
	}
	@PostMapping("/ninjas/new")
	private String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "newNinja.jsp";
		} else {
			ninjaService.save(ninja);
			return "redirect:/dojos/" + ninja.getDojo().getId();
		}
	}
	@GetMapping("/dojos/{id}")
	private String showDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.findById(id));
		
		return "dojoInfo.jsp";
	}
}
