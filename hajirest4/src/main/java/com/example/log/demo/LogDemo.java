package com.example.log.demo;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class LogDemo {

	//final Logger logger = LoggerFactory.getLogger(LogDemo.class);

	public void logTest(){
		String s = "99";
		String s1= "01";
		
		// TODO Auto-generated method stub
		    log.info("Hello World");
		    
		    log.debug("Temperature set to {}. Old temperature was {}.", s,s1);
		    
		    log.warn("this is warning message");

	}

}
