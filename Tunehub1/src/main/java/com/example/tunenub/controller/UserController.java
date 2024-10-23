package com.example.tunenub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tunenub.entity.Song;
import com.example.tunenub.entity.User;
import com.example.tunenub.serviceimpl.SongServiceImpl;
import com.example.tunenub.serviceimpl.UserserviceImpl;

import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;


@Controller
public class UserController {
	@Autowired
	UserserviceImpl userserviceimpl;
	
	@Autowired
	SongServiceImpl songServiceImpl;
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute User user) {


		// email taken from registration form
		String email=user.getEmail();
		//checking if email as entered in registration from
		// is present in DB or not
		boolean status=userserviceimpl.emailExists(email);
		if(status==false) {
			userserviceimpl.addUser(user);
			System.out.println("user added");
		}
		else {
			System.out.println("user already exists");
		}
return "login";
	}


@PostMapping("/validate")
public String validate(@RequestParam("email")  String email,
		@RequestParam("password")String password,  HttpSession session,Model model) {
	if(userserviceimpl.validateUser(email,password)== true) {
		String role=userserviceimpl.getRole(email);
		session.setAttribute("email", email);
		if(role.equals("admin")) {
			return "adminhome";
		}
		else {
			
			User user=userserviceimpl.getUser(email);
			boolean userstatus =user.isIspremium();
		        // logic only one retrive in show front page
			List<Song>  fetchAllSongs=songServiceImpl.fetchAllSongs();
			model.addAttribute("songs", fetchAllSongs);
			
		model.addAttribute("ispremium", userstatus);
			return"customerhome";
		}
		
		
	}
	else {
		return "login";
	}


		
	}
@GetMapping("/logout")
public String logout(HttpSession session) {
	session.invalidate();
	return "login";
}



@GetMapping("/exploresongs")
public String exploresongs(String email) {
	return email;


}

	
	
	

}
