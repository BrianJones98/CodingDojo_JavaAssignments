package com.brian.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brian.languages.models.Language;
import com.brian.languages.services.LanguageService;

@Controller
public class LanguageController {
	
	@Autowired
	private LanguageService languageService;
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/languages";
	}
	
	@RequestMapping("/languages")
	public String languages(@ModelAttribute("language") Language language, Model model) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		
		return "languages.jsp";
	}
	@RequestMapping(value="/languages", method=RequestMethod.POST)
	public String addLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Language> languages = languageService.allLanguages();
			model.addAttribute("languages", languages);
			//CANNOT BE A REDIRECT
			return "languages.jsp";
		}else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	@RequestMapping("/languages/{id}")
	public String showLanguage(@PathVariable("id") Long id, Model model) {
		model.addAttribute("language", languageService.findLanguage(id));
		
		return "info.jsp";
	}
	@RequestMapping("/languages/edit/{id}")
	public String editLanguage(@PathVariable("id") Long id, Model model) {
		model.addAttribute("language", languageService.findLanguage(id));
		
		return "edit.jsp";
	}
	@RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			languageService.updateLanguage(language.getId(), language.getLangName(), language.getCreator(), language.getVersion());
			return "redirect:/languages";
		}
	}
	@RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
}
