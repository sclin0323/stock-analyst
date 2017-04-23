package com.aistock.analyst.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aistock.analyst.service.TestService;

@RestController
@RequestMapping(value="/test")
public class TestController {
	
	@Autowired
	TestService testService;
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String show(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//System.out.println(urlPrefix);
		
		testService.show();
		
		return "test show";
		
		
	}
}
