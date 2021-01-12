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

	// �θ� Ŭ������ ������ ȣ��
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	// MemberVO�� �Ķ���ͷ� �����ؼ� User Ŭ������ �°� ������ ȣ��
	public CustomUser(MemberVO member) {

		super(member.getMember_id(), member.getMember_pass(), member.getAuthList()
				.stream().map(auth -> new SimpleGrantedAuthority(auth.getMember_auth())).collect(Collectors.toList()));

		this.member = member;
	}
}
