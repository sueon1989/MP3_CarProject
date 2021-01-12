package com.mp3.service;

import com.mp3.domain.MemberVO;

public interface MypageService {

	//마이페이지 회원번호로 내정보 상세보기
	public MemberVO myInfoRead(Long member_no);
	
	//마이페이지 회원탈퇴 비밀번호 확인
	public boolean myInfoDeletePassCheck(Long member_no);
	
	
	// 마이페이지 내 정보 수정
	public boolean myInfoUpdate(MemberVO member);
	
	
//	//마이페이지 회원 탈퇴
//	public boolean myInfoDeleteFinished(Long member_no);
//	
}
