package com.example.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
	public static void main(String[] args){
		String pass ="demo";
		
		BCryptPasswordEncoder bcEncoder =new BCryptPasswordEncoder();
		String encodedPass =bcEncoder.encode(pass);
		
		System.out.println(pass+"=" + encodedPass);
		System.out.println("result=" + bcEncoder.matches(pass, encodedPass));
	}
}
