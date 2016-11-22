package com.interview.services;

import com.interview.response.VideoResponse;

public interface VideoService {

	VideoResponse  getVideoOfUserId(Long userID);

	VideoResponse postVideoOfUserId(Long usreID);

	VideoResponse updateVideoOfUserId(Long userID);

	
	
	
}
