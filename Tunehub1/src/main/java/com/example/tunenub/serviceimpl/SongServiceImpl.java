package com.example.tunenub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tunenub.entity.Song;
import com.example.tunenub.repository.SongRepository;
import com.example.tunenub.service.SongService;
@Service
public class SongServiceImpl implements SongService {
	@Autowired
	SongRepository songRepository;
	
	@Override
	public String addSong(Song song) {
		songRepository. save(song);
		return "Song added successfully";

	}

	@Override
	public boolean songExists(String name) {
	Song song = songRepository.findByName(name);
	if(song==null) {
		return false;
	}
	else {
		return true;
	}
	}
				
	
public void updateSong(Song s) {
	songRepository.save(s);
	
		
	}	
	
	
	@Override
	public List<Song> fetchAllSongs() {
		List<Song> songs =songRepository.findAll();
		return songs;
	}

	
	
	

	
	}


