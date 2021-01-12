package com.mp3.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mp3.domain.CustomUser;
import com.mp3.domain.MemberVO;
import com.mp3.mapper.MemberMapper;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		log.warn("사용자 ID: " + userName);

		// userName means userid
		MemberVO member = mapper.read(userName);

		log.warn("사용자 정보: " + member);
		
		return member == null ? null : new CustomUser(member);
	}

}
