package com.example.tunenub.service;

import java.util.List;

import com.example.tunenub.entity.Song;

public interface SongService {
	public String addSong(Song song);
	public List<Song> fetchAllSongs();
	public boolean songExists(String name);
	public void updateSong(Song s);

}
