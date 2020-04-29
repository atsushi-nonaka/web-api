package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.example.domain.Receive;
import com.example.domain.Send;
import com.example.service.TestService;

@Controller
@RequestMapping("")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@Bean
	public RestTemplate RestTemplate() {
		return new RestTemplate();
	}
	
	@RequestMapping("")
	public String start() {
		return "start";
	}
	
	@RequestMapping("/execution")
	public String execuse() {
		Send send = new Send();
		send.setName("野中　敦史");
		send.setAge(26);
		System.out.println("API start");
		Receive receive = testService.execution(send);
		System.out.println("API finish");
		System.out.println(receive);
		return "finish";
	}
}
