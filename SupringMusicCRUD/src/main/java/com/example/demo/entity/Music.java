package com.example.demo.entity;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Music {
	@Id
	private Integer song_id;
	private String song_name;
	private String singer;
	
    public List<String> getSingerList() {
        return Arrays.asList(singer.split(", "));
    }

    public void setSingerList(List<String> singerList) {
        this.singer = String.join(", ", singerList);
    }
}