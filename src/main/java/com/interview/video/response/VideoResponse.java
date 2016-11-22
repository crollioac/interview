package com.interview.video.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.interview.video.entity.PrimaryVideo;

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
