package com.example.log.demo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggerDemo {
	public static void main(String[] args) {
		  System.out.println("START!");
		  log.info("log です");
		  LogDemo logDemo = new LogDemo();
		  logDemo.logTest();
		  
	  }
}
