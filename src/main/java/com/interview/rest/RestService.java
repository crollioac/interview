package com.interview.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {

	public <T> ResponseEntity<T> get(String url, Class<T> responseType, String accessToken) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		if (accessToken != null && !accessToken.isEmpty()) {
			headers.set(HttpHeaders.AUTHORIZATION, accessToken);
		}
		HttpEntity<String> requestEntity = new HttpEntity<>("parameters", headers);

		return restTemplate.exchange(url, HttpMethod.GET, requestEntity, responseType);
	}

	public <T> ResponseEntity<T> post(String url, String body, Class<T> responseType, String accessToken) {
		HttpHeaders headers = new HttpHeaders();
		if (accessToken != null && !accessToken.isEmpty()) {
			headers.set(HttpHeaders.AUTHORIZATION, accessToken);
		}
		headers.setContentType(MediaType.APPLICATION_JSON);
		return post(url, body, responseType, headers);
	}

	public <T> ResponseEntity<T> post(String url, String body, Class<T> responseType, HttpHeaders headers) {
		RestTemplate restTemplate = new RestTemplate();

		restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
		HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);

		return restTemplate.exchange(url, HttpMethod.POST, requestEntity, responseType);
	}

	public <T> ResponseEntity<T> postUrlEncoded(String url, MultiValueMap<String, String> body, Class<T> responseType,
			String accessToken) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		if (accessToken != null && !accessToken.isEmpty()) {
			headers.set(HttpHeaders.AUTHORIZATION, accessToken);
		}
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);

		return restTemplate.exchange(url, HttpMethod.POST, requestEntity, responseType);
	}

	public <T> ResponseEntity<T> put(String url, String body, Class<T> responseType, String accessToken) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		if (accessToken != null && !accessToken.isEmpty()) {
			headers.set(HttpHeaders.AUTHORIZATION, accessToken);
		}
		headers.setContentType(MediaType.APPLICATION_JSON);

		restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
		HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);

		return restTemplate.exchange(url, HttpMethod.PUT, requestEntity, responseType);
	}

	public <T> ResponseEntity<T> delete(String url, String body, Class<T> responseType, String accessToken) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		if (accessToken != null && !accessToken.isEmpty()) {
			headers.set(HttpHeaders.AUTHORIZATION, accessToken);
		}
		headers.setContentType(MediaType.APPLICATION_JSON);

		restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
		HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);

		return restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, responseType);
	}

}
