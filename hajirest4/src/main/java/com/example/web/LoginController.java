package com.example.web;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springsource.loaded.Log;

@Controller
@Slf4j
public class LoginController {
	@RequestMapping("loginForm")
	String loginForm() {
		log.info("LoginFormが呼ばれました。!!!!!!llllooooo");
		return "loginForm.html";
	}
}


