package com.example.tunenub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tunenub.entity.Playlist;
import com.example.tunenub.repository.PlaylistRepository;
import com.example.tunenub.service.PlaylistService;

@Service
public class PlaylistServiceImpl implements PlaylistService{
	@Autowired
	PlaylistRepository playlistRepository;

	public void addplaylist(Playlist playlist) {
		
		playlistRepository.save(playlist);
	}
@Override
	public List<Playlist> fetchAllPlaylists() {
	List<Playlist> allplaylist=	playlistRepository.findAll();
		return allplaylist;
	}

	

	

}
