package com.brian.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brian.lookify.models.Song;

@Repository
public interface SongRepo extends CrudRepository<Song, Long> {
	List<Song> findAll();
	List<Song> findByArtistContaining(String search);
	List<Song> findTop10ByOrderByRatingDesc();
}
