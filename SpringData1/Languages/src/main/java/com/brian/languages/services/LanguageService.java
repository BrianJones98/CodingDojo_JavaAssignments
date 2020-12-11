package com.brian.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brian.languages.models.Language;
import com.brian.languages.repositories.LanguageRepo;

@Service
public class LanguageService {
	@Autowired
	private LanguageRepo languageRepo;
	
	public List<Language> allLanguages() {
		return languageRepo.findAll();
	}
	public Language createLanguage(Language lang) {
		return languageRepo.save(lang);
	}
	public Language findLanguage(Long id) {
		Optional<Language> lang = languageRepo.findById(id);
		if(lang.isPresent()) {
			return lang.get();
		} else {
			return null;
		}
	}
	public Language updateLanguage(Long id, String name, String creator, String version) {
		Language lang = findLanguage(id);
		lang.setLangName(name);
		lang.setCreator(creator);
		lang.setVersion(version);
		
		return languageRepo.save(lang);
	}
	public void deleteLanguage(Long id) {
		Language lang = findLanguage(id);
		languageRepo.delete(lang);
	}
}
