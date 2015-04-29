package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springsource.loaded.Log;

@Controller
public class LoginController {
	@RequestMapping("loginForm")
	String loginForm() {
		Log.log("LoginFormが呼ばれました。");
		return "loginForm";
	}
}
