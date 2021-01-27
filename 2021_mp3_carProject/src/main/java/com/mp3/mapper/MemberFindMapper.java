package com.mp3.mapper;

import org.apache.ibatis.annotations.Param;

import com.mp3.domain.MemberVO;

public interface MemberFindMapper {
	
	//아이디 찾기(이메일)
	public MemberVO MemverIDFindMail(MemberVO member);					

	//비밀번호 찾기(이메일)
	public int MemverPassFindMail(MemberVO member);
	
	//이름 중복체크
	public int namecheck(MemberVO member);
	

	

}
