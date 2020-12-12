package com.brian.license.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.brian.license.models.License;
import com.brian.license.models.Person;
import com.brian.license.services.LicenseService;
import com.brian.license.services.PersonService;

@Controller
public class DriversLicenseController {
	
	@Autowired
	private PersonService personService;
	@Autowired
	private LicenseService licenseService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/person/new";
	}
	@GetMapping("/person/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "newPerson.jsp";
	}
	@PostMapping("/person/new")
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "newPerson.jsp";
		} else {
			personService.save(person);
			return "redirect:/person/" + person.getId();
		}
	}
	@GetMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> persons = personService.allPeople();
		model.addAttribute("persons", persons);
		
		return "newLicense.jsp";
	}
	@PostMapping("/licenses/new")
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if(result.hasErrors()) {
			return "newLicense.jsp";
		} else {
			license.setNumber(String.format("%05d", license.getPerson().getId()));
			licenseService.save(license);
			return "redirect:/person/" + license.getPerson().getId();
		}
	}
	@GetMapping("/person/{id}")
	public String showPerson(Model model, @PathVariable("id") Long id) {
		model.addAttribute("person", personService.findById(id));
		
		return "info.jsp";
	}
}
