package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerDemo {

	  public static void main(String[] args) {
	    Logger logger = LoggerFactory.getLogger(LoggerDemo.class);
	    logger.info("Hello World");
	  }
}
