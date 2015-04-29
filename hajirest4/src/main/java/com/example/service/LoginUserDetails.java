package com.example.service;



import lombok.Data;

import org.springframework.security.core.authority.AuthorityUtils;

import com.example.domain.User;

@Data
public class LoginUserDetails extends org.springframework.security.core.userdetails.User{
	private final User user; //実際のユーザオブジェクトを取得できるように
	
	public LoginUserDetails(User user){
		super(user.getUsername(),user.getEncodedPassword(),AuthorityUtils.createAuthorityList("ROLE_USER")); //ユーザ名、パスワード、認可用のロールを作る
		this.user = user;
	}

}
