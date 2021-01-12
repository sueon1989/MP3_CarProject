package com.mp3.domain;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class CustomUser extends User {

	private static final long serialVersionUID = 1L;

	private MemberVO member;

	// 부모 클래스의 생성자 호출
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	// MemberVO를 파라미터로 전달해서 User 클래스에 맞게 생성자 호출
	public CustomUser(MemberVO member) {

		super(member.getMember_id(), member.getMember_pass(), member.getAuthList()
				.stream().map(auth -> new SimpleGrantedAuthority(auth.getMember_auth())).collect(Collectors.toList()));

		this.member = member;
	}
}
