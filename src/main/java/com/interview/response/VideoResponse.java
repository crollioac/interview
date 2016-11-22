package com.interview.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.interview.entity.PrimaryVideo;

@Component
public class VideoResponse {

	
	private List<PrimaryVideo> primaryVideo;

	public List<PrimaryVideo> getPrimaryVideo() {
		return primaryVideo;
	}

	public void setPrimaryVideo(List<PrimaryVideo> primaryVideo) {
		this.primaryVideo = primaryVideo;
	}
}
