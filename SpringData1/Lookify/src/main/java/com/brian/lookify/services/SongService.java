package com.brian.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brian.lookify.models.Song;
import com.brian.lookify.repositories.SongRepo;

@Service
public class SongService {
	@Autowired
	private SongRepo songRepo;
	
	public List<Song> findAll(){
		return songRepo.findAll();
	}
	public Song findById(Long id) {
		Optional<Song> song = songRepo.findById(id);
		if(song.isPresent()) {
			return song.get();
		} else {
			return null;
		}
	}
	public Song save(Song song) {
		return songRepo.save(song);
	}
	public void delete(Long id) {
		songRepo.deleteById(id);
	}
	public List<Song> findByArtistContaining(String search){
		return songRepo.findByArtistContaining(search);
	}
	public List<Song> getTopTen(){
		return songRepo.findTop10ByOrderByRatingDesc();
	}
}
