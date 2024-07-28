package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Music;

public interface MusicsService {
	Iterable<Music> findAll();

	Music save(Music music);
	
    void deleteById(int id);
    
    Optional<Music> findById(int id);
}