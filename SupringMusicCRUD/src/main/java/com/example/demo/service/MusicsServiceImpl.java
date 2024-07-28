package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Music;
import com.example.demo.repository.MusicCrudRepository;



@Service
public class MusicsServiceImpl implements MusicsService {
    
    @Autowired
    MusicCrudRepository repository;
    
    @Override
    public Iterable<Music> findAll() {
        return repository.findAll();
    }
    
    @Override
    public Music save(Music music) {
        return repository.save(music);
    }
    
    @Override
    public void deleteById(int id) {
    	repository.deleteById(id);
    }

    @Override
    public Optional<Music> findById(int id) {
        return repository.findById(id);
    }
}