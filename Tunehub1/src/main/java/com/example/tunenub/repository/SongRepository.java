package com.example.tunenub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tunenub.entity.Song;

public interface SongRepository extends JpaRepository<Song, Integer> {

public Song findByName(String name);

	

}
