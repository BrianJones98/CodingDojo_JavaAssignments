package com.brian.lookify.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.brian.lookify.models.Song;
import com.brian.lookify.services.SongService;

@Controller
public class MainController {
	@Autowired
	private SongService songService;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	@GetMapping("/dashboard")
	public String dashboard(Model model, @ModelAttribute("search") String search) {
		model.addAttribute("songs", songService.findAll());
		
		return "dashboard.jsp";
	}
	@PostMapping("/search")
	public String search(@RequestParam("search") String search) {
		return "redirect:/search/" + search;
	}
	@GetMapping("/search/{search}")
	public String searchResults(Model model, @PathVariable("search") String search) {
		model.addAttribute("songs", songService.findByArtistContaining(search));
		return "searchResults.jsp";
	}
	@GetMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "newSong.jsp";
	}
	@PostMapping("/songs/new")
	public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "newSong.jsp";
		} else {
			songService.save(song);
			return "redirect:/dashboard";
		}
	}
	@GetMapping("/search/top-ten")
	public String topTen(Model model) {
		model.addAttribute("songs", songService.getTopTen());
		return "topTen.jsp";
	}
	@GetMapping("/songs/{id}")
	public String showInfo(@PathVariable Long id, Model model) {
		model.addAttribute("song", songService.findById(id));
		return "showInfo.jsp";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		songService.delete(id);
		return "redirect:/dashboard";
	}
}
