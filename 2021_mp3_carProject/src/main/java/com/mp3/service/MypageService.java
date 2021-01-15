package com.mp3.service;

import com.mp3.domain.CarVO;
import com.mp3.domain.MemberVO;

public interface MypageService {

	//마이페이지 회원번호로 내정보 상세보기
	public MemberVO myInfoRead(Long member_no);
	
	//마이페이지 차 번호로 내 차 정보 상세 보기
	public CarVO myInfoCar(Long car_no);
	
	//마이페이지 회원탈퇴 비밀번호 확인
	public boolean myInfoDeletePassCheck(Long member_no,String Deletenum,String Deletenum1);
	
	
	// 마이페이지 내 정보 수정
	public boolean myInfoUpdatePassCheck(MemberVO member);
	
	
	//마이페이지 회원 탈퇴
	public boolean myInfoDeleteFinished(Long member_no);
	
	//사용자가 회원탈퇴시 입력한 비밀번호 저장
	public MemberVO DeleteNum(String deletenum);
	
    //탈퇴시 패스워드 체크
    public int passChk(MemberVO member);
    
    //탈퇴시 아이디로 체크
    public String passID(String member_id);
	
}




