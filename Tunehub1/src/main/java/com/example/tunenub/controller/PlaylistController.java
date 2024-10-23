package com.example.tunenub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tunenub.entity.Playlist;
import com.example.tunenub.entity.Song;
import com.example.tunenub.serviceimpl.PlaylistServiceImpl;
import com.example.tunenub.serviceimpl.SongServiceImpl;

@Controller
public class PlaylistController {
	@Autowired
	SongServiceImpl songServiceImpl;
	
	@Autowired
	PlaylistServiceImpl playlistServiceImpl;
	
	
	@GetMapping("/createplaylists")	
	public String Createplaylists(Model model) {
		List<Song> songList =songServiceImpl.fetchAllSongs();
		model.addAttribute("songs", songList);
		
		return "createplaylists";
 }
	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute Playlist playlist) {
		//updating the playlist table
		playlistServiceImpl.addplaylist(playlist);
		//updating the song table
		List<Song> songList=playlist.getSongs();
		for(Song s: songList) {
			s.getPlaylists().add(playlist);
			songServiceImpl.updateSong(s);
	}
		return "adminhome";
		
	}
	
	@GetMapping("/viewplaylists")	
	public String viewplaylists(Model model) {
		List<Playlist> allplaylist =playlistServiceImpl.fetchAllPlaylists();
		model.addAttribute("allplaylists", allplaylist);
		
		return "displayplaylist";
 }
	

}
