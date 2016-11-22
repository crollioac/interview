package com.interview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.interview.response.VideoResponse;
import com.interview.services.VideoService;

@RestController
@RequestMapping(value = "/api")
public class VideoController {

	@Autowired
	private VideoService videoService;

	@RequestMapping(value = "/video/{userId}", method = RequestMethod.GET, produces = "application/json")
	public VideoResponse getVideoOfUserId(@PathVariable("userId") final Long userID) {
		System.out.println("success");

		return videoService.getVideoOfUserId(userID);

	}

	@RequestMapping(value = "/video/{userId}", method = RequestMethod.POST, produces = "application/json")
	public VideoResponse postVideoOfUserId(@PathVariable("userId") final Long usreID) {
		return videoService.postVideoOfUserId(usreID);

	}

	@RequestMapping(value = "/video/{userId}", method = RequestMethod.PUT, produces = "application/json")
	public VideoResponse updateVideoOfUserId(@PathVariable("userId") final Long usreID) {
		return videoService.updateVideoOfUserId(usreID);

	}

}
