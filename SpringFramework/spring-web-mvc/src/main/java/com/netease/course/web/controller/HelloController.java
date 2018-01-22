package com.netease.course.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.Writer;

/**
 * @author menglanyingfei
 * @date 2017-8-23
 */

@Controller
public class HelloController {

    // http://localhost:8080/spring-web-mvc/api/users/123?msg=666
	@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
	public void spring(@PathVariable("userId") String userId,
                       @RequestParam("msg") String msg,
                       @RequestHeader("host") String host, Writer writer)
			throws IOException {
		// writer.write("Hello, Spring Web!!");
		writer.write("userId=" + userId + ", msg=" + msg + ", hostHeader=" + host);

		// userId=123, msg=666, hostHeader=localhost:8080
	}
	
	@RequestMapping("/users/login")
	//@ResponseBody
	public String login(
			@RequestParam("name") String name,
			@RequestParam("password") String password, ModelMap map)
			throws IOException {
		//return "Name: " + name + "<p /> Password: " + password;
		map.addAttribute("name", name);
		map.addAttribute("password", password);
		
		return "user";
	}
}











