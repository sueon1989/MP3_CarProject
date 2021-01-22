package com.mp3.service;

import java.util.List;

import com.mp3.domain.AuthVO;
import com.mp3.domain.MemberVO;

// 담당자: kim
public interface MemberService {

	public List<MemberVO> getList();				// 회원목록 (관리자)
	boolean register(MemberVO member, AuthVO auth);	// 회원가입
	public MemberVO get(String userid);				// 회원정보 조회
	public boolean remove(String member_id);		// 회원탈퇴
	
	public boolean modify(MemberVO member);			// 내 정보 수정
	
	public boolean checkId(MemberVO member);			// 아이디 중복체크
	
}
