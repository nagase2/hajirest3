package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springsource.loaded.Log;

@Controller
public class JSPTestController {

	
	@RequestMapping("/jsptest")
	String JSPTest() {
		Log.log("JSP test が呼ばれました。");
		return "jsptest";
	}
}


