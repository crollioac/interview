package com.interview.video.services;

import com.interview.video.response.VideoResponse;

public interface VideoService {

	VideoResponse  getVideoOfUserId(Long userID);

	VideoResponse postVideoOfUserId(Long usreID);

	VideoResponse updateVideoOfUserId(Long userID);

	
	
	
}
