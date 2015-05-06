package com.example.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.thymeleaf.standard.expression.Each;

public class PasswordGenerator {
	public static void main(String[] args){
		String pass ="demo";
		
		BCryptPasswordEncoder bcEncoder =new BCryptPasswordEncoder();
		String encodedPass =bcEncoder.encode(pass);
		
		System.out.println(pass+"=" + encodedPass);
		System.out.println("result=" + bcEncoder.matches(pass, encodedPass));
		System.out.println("this is test code(com.example.domain.PasswordGenerator.java:4)");

		System.out.println("this is Not OK  c.e.c.PasswordGenerator.main(PasswordGenerator.java:19)");
		System.out.println("this is OK  com.example.common.PasswordGenerator.main(PasswordGenerator.java:19)");
		
		bcEncoder=null;
		bcEncoder.toString();
		
	}
}
