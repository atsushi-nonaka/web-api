package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.domain.Receive;
import com.example.domain.Send;

@Service
public class TestService {
	
	@Autowired
	private RestTemplate restTemplate;

	private static final String URL = "http://192.168.11.7:8080/web-api-return/";


	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	public Receive execution(Send send) {
        return restTemplate.postForObject(URL, send, Receive.class);
    }
}
