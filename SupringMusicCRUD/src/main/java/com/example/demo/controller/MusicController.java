package com.example.demo.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Music;
import com.example.demo.service.MusicsService;

@Controller
public class MusicController {
	
	@Autowired
	MusicsService service;
	
	@GetMapping("/")
    public String indexView() {
        return "index";
    }

    @PostMapping(value="/move", params="list")
    public String listView(Model model) {
        Iterable<Music> list = service.findAll();
        model.addAttribute("list", list);
        return "list";
    }
    
    @PostMapping(value="/move", params="insert")
    public String insertView(Model model) {
        model.addAttribute("music", new Music());
        return "insert";
    }
    
    @PostMapping(value="/move", params="update")
    public String updateView(Model model) {
        Iterable<Music> musicList = service.findAll();
        model.addAttribute("musicList", musicList);
        return "update";
    }
    
    @PostMapping(value="/move", params="delete")
    public String deleteView(Model model) {
        Iterable<Music> musicList = service.findAll();
        model.addAttribute("musicList", musicList);
        return "delete";
    }
    
    @PostMapping("/confirm")
    public String confirm(@RequestParam("song_name") String songName, @RequestParam("singer[]") List<String> singer, Model model) {
        Music music = new Music();
        music.setSong_name(songName);
        music.setSingerList(singer);
        model.addAttribute("music", music);
        return "confirm";
    }

    @PostMapping("/register")
    public String register(@RequestParam("song_name") String songName, @RequestParam("singer") String singer, Model model) {
        Music newMusic = new Music();
        newMusic.setSong_name(songName);
        newMusic.setSinger(singer);
        service.save(newMusic);
        return "complete";
    }

    @PostMapping("/update")
    public String update(@RequestParam("song_id") int id, @RequestParam("song_name") String songName, @RequestParam("singer[]") List<String> singer, Model model) {
        Optional<Music> existingMusic = service.findById(id);
        if (existingMusic.isPresent()) {
            Music updatedMusic = existingMusic.get();
            updatedMusic.setSong_name(songName);
            updatedMusic.setSingerList(singer);
            service.save(updatedMusic);
            return "complete";
        } else {
            return "error";
        }
    }
    
    @PostMapping("/deleteConfirm")
    public String deleteConfirm(@RequestParam("song_id") int songId, Model model) {
        Optional<Music> musicOptional = service.findById(songId);
        if (musicOptional.isPresent()) {
            model.addAttribute("music", musicOptional.get());
            return "deleteConfirm";
        } else {
            return "error";
        }
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("song_id") int songId) {
        service.deleteById(songId);
        return "complete";
    }
}