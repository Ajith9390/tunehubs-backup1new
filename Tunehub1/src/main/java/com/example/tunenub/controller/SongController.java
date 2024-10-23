package com.example.tunenub.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tunenub.entity.Song;
import com.example.tunenub.serviceimpl.SongServiceImpl;

import org.springframework.ui.Model;

@Controller
public class SongController {
	@Autowired
	SongServiceImpl songServiceImpl;
	
	@PostMapping("/addsong")
	public String addsong(@ModelAttribute Song song) {
		
		boolean songStatus= songServiceImpl.songExists(song.getName());
		if(songStatus==false) {
			songServiceImpl.addSong(song);
		System.out.println("Song added Successfully");
		}
		else {
			System.out.println("Song already exists");
		}
		return "adminhome";
	}
		
	@GetMapping("/viewsongs")	
	public String viewsongs(Model model) {
		List<Song> songList =songServiceImpl.fetchAllSongs();
		model.addAttribute("songs", songList);
		
		return "displaysongs";
 }
	
	
	
@GetMapping("/playsongs")	
public String playsongs(Model model) {
	boolean premium = false;
	if(premium) {
		List<Song> songList = songServiceImpl.fetchAllSongs();
		model.addAttribute("songs", songList);
		return "displaysongs";
	}
	else {
		return "subscriptionform";
	}
	
}

}
