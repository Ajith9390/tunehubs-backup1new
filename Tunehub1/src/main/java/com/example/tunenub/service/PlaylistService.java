package com.example.tunenub.service;

import java.util.List;

import com.example.tunenub.entity.Playlist;

public interface PlaylistService {
	public void addplaylist(Playlist playlist);
	public List<Playlist> fetchAllPlaylists();
	


}
