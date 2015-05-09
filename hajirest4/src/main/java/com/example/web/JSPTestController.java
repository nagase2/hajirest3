package com.example.web;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class JSPTestController {

	
	@RequestMapping("/jsptest")
	String JSPTest() {
		log.info("JSP test が呼ばれました。!!");
		return "jsptest";
	}
}


